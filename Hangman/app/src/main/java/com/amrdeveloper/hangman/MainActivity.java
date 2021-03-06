package com.amrdeveloper.hangman;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            Sawo(
                    this,
                    "7d161977-3fc4-4d2a-afb3-67fbb72dd5b2", // your api key
                    "61601a9e5e9b584a31c7e787KljsATtUY3CHZPAHrbcNb5F8"  // your api key secret
            ).login(
                    "email", // can be one of 'email' or 'phone_number_sms'
                    WordsLoader::class.java.name // Callback class name
            )
        }
    }

    private TextView attemptsNumberTxt;
    private TextView hangmanWordTxt;
    private GridView charsGridView;

    private WordsLoader wordsLoader;
    private HangmanController hangmanController;
    private CharactersGridAdapter adapter;

    private String encryptedWord = "";
    private String currentTrueWords = "";
    private int currentInvalidAnswers = INVALID_ANSWERS_NUMBER;

    private static final int INVALID_ANSWERS_NUMBER = 5;
    private static final String INVALID_NUMBER_FORMAT = "Attempts Number : %d";
    private static List<String> alphabetChars = AlphabetGenerator.getAlphabetChars();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        wordsLoader = new WordsLoader(this);
        hangmanController = new HangmanController();
        adapter = new CharactersGridAdapter(this, alphabetChars);

        reCreateGame();
    }

    private void initViews() {
        attemptsNumberTxt = findViewById(R.id.attemptsNumberTxt);
        hangmanWordTxt = findViewById(R.id.hangmanWordTxt);
        charsGridView = findViewById(R.id.charsGridView);
        charsGridView.setOnItemClickListener(onCharItemClickListener);
    }

    private void reCreateGame() {
        currentInvalidAnswers = INVALID_ANSWERS_NUMBER;
        currentTrueWords = wordsLoader.getRandomWord();
        encryptedWord = hangmanController.createEncryptedWord(currentTrueWords);
        hangmanWordTxt.setText(encryptedWord);
        attemptsNumberTxt.setText(String.format(Locale.ENGLISH, INVALID_NUMBER_FORMAT, currentInvalidAnswers));
        adapter.notifyDataSetChanged();
        charsGridView.invalidateViews();
        charsGridView.setAdapter(adapter);
    }

    private void showWinDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Game Result")
                .setMessage("Congratulation you win this game, Do you want to play again?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                    reCreateGame();
                })
                .setNegativeButton(android.R.string.no, (dialog, whichButton) -> {
                    finish();
                }).show();
    }

    private void showLoseDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Game Result")
                .setMessage("You are lose this game, the word is :" + currentTrueWords + "\n, Do you want to play again?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                    reCreateGame();
                })
                .setNegativeButton(android.R.string.no, (dialog, whichButton) -> {
                    finish();
                }).show();
    }

    private AdapterView.OnItemClickListener onCharItemClickListener = (parent, view, position, id) -> {
        View currentCharView = adapter.getView(position, view, parent);
        currentCharView.setVisibility(View.INVISIBLE);

        String currentCharStr = adapter.getItem(position);

        boolean isValidAnswer = hangmanController.isValidCharacter(currentTrueWords, currentCharStr);
        if (isValidAnswer) {
            String newWord = hangmanController.showPlayerAnswer(currentTrueWords, encryptedWord, currentCharStr);
            encryptedWord = newWord;
            hangmanWordTxt.setText(encryptedWord);
            if (newWord.equals(currentTrueWords)) {
                showWinDialog();
            }
        } else {
            currentInvalidAnswers--;
            attemptsNumberTxt.setText(String.format(Locale.ENGLISH, INVALID_NUMBER_FORMAT, currentInvalidAnswers));
            if (currentInvalidAnswers == 0) {
                showLoseDialog();
            }
        }
    };
}
