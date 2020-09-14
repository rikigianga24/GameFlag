package riccardo.games.gameflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class ActivityGame extends AppCompatActivity {

    private Random r;
    private int turn;
    private ImageView flag;
    private List<CountryItem> list;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView textTurn;
    private ProgressBar progressBar; //estetica
    private TextView errorView;
    private int errorCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        turn = 1;
        errorCounter = 0;
        r = new Random();
        flag = findViewById(R.id.flag);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);
        textTurn = findViewById(R.id.txtTurn);
        errorView = findViewById(R.id.txtError);


        list = new ArrayList<>();

        //aggiungo i nomi e le immagini alla lista con gli elementi della classe database
        for (int i = 0; i < new Database().answers.length; i++) {
            list.add(new CountryItem(new Database().answers[i], new Database().flags[i]));
        }

        //mescolo bandiere e risposte
        Collections.shuffle(list);


        newQuestion(turn);
        updateTextView(turn);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if (answer1.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();
                    updateTextView(turn);

                    //controllo che sia l'ultima domanda
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(ActivityGame.this, "Partita conclusa", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();
                    vibrate();
                    checkErrors();

                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if (answer2.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();
                    updateTextView(turn);

                    //controllo che sia l'ultima domanda
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(ActivityGame.this, "Partita conclusa", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();
                    vibrate();
                    checkErrors();

                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if (answer3.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();
                    updateTextView(turn);

                    //controllo che sia l'ultima domanda
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(ActivityGame.this, "Partita conclusa", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();
                    vibrate();
                    checkErrors();

                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if (answer4.getText().toString().equalsIgnoreCase(list.get(turn - 1).getName())) {
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();
                    updateTextView(turn);

                    //controllo che sia l'ultima domanda
                    if (turn < list.size()) {
                        turn++;
                        newQuestion(turn);
                    } else {
                        Toast.makeText(ActivityGame.this, "Partita conclusa", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();
                    vibrate();
                    checkErrors();
                }

            }
        });

    }

    public void vibrate() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);
    }

    public void updateTextView(int turn) {
        textTurn.setText(turn + " / " + list.size());//iniializzo la textView
    }

    public void checkErrors() {
        errorCounter++;
        errorView.setText(errorCounter + " / " + 5);

        if (errorCounter == 5) {
            Toast.makeText(ActivityGame.this, "Partita Conclusa!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void newQuestion(int number) {

        //cambio la bandiera del quiz prendendola dalla lista
        flag.setImageResource(list.get(number - 1).getImage());

        //sceglo in modo casuale tra i 4 pulsanti quello con la soluzione giusta
        int correct_answer = r.nextInt(4) + 1;

        int firstButton = number - 1;
        int secondButton;
        int thirdButton;
        int forthButton;

        switch (correct_answer) {
            case 1:
                //cambio il testo del primo bottone con il nome della bandiera giusta
                answer1.setText(list.get(firstButton).getName());

                //con il do-while controllo che le risposte nei pulsanti siano tutte diverse e una giusta
                do {
                    secondButton = r.nextInt(list.size()); //assegno un indice randomico per la risposta
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                answer2.setText(list.get(secondButton).getName());
                answer3.setText(list.get(thirdButton).getName());
                answer4.setText(list.get(forthButton).getName());

                break;
            case 2:
                //cambio il testo del primo bottone con il nome della bandiera giusta
                answer2.setText(list.get(firstButton).getName());

                //con il do-while controllo che le risposte nei pulsanti siano tutte diverse e una giusta
                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                answer1.setText(list.get(secondButton).getName());
                answer3.setText(list.get(thirdButton).getName());
                answer4.setText(list.get(forthButton).getName());
                break;
            case 3:
                //cambio il testo del terzo bottone con il nome della bandiera giusta
                answer3.setText(list.get(firstButton).getName());

                //con il do-while controllo che le risposte nei pulsanti siano tutte diverse e una giusta
                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                answer2.setText(list.get(secondButton).getName());
                answer1.setText(list.get(thirdButton).getName());
                answer4.setText(list.get(forthButton).getName());
                break;
            case 4:
                //cambio il testo del primo bottone con il nome della bandiera giusta
                answer4.setText(list.get(firstButton).getName());

                //con il do-while controllo che le risposte nei pulsanti siano tutte diverse e una giusta
                do {
                    secondButton = r.nextInt(list.size());
                } while (secondButton == firstButton);

                do {
                    thirdButton = r.nextInt(list.size());
                } while (thirdButton == firstButton || thirdButton == secondButton);

                do {
                    forthButton = r.nextInt(list.size());
                } while (forthButton == firstButton || forthButton == secondButton || forthButton == thirdButton);

                answer2.setText(list.get(secondButton).getName());
                answer3.setText(list.get(thirdButton).getName());
                answer1.setText(list.get(forthButton).getName());
                break;
        }

    }


}

