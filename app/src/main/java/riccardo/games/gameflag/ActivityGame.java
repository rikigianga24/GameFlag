package riccardo.games.gameflag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;


//TODO Randomico posizioni delle risposte
//TODO randomico immagini vedi rollthedice

public class ActivityGame extends AppCompatActivity {

    private Random r;
    private int turn;
    private ImageView flag;
    List<CountryItem> list;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        turn = 1;

        r = new Random();
        flag= findViewById(R.id.flag);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answer4 = findViewById(R.id.answer4);

        list = new ArrayList<>();

        //aggiungo i nomi e le immagini alla lista
        for (int i = 0; i < new Database().answers.length; i++) {
            list.add(new CountryItem(new Database().answers[i], new Database().flags[i]));

        }

        //mescolo bandiere e risposte
        Collections.shuffle(list);

        newQuestion(turn);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //controllo se la risposta è giusta
                if(answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();

                    //controllo che sia l'ultima domanda
                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(ActivityGame.this, "Partita conclusa",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();


                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if(answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();

                    //controllo che sia l'ultima domanda
                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(ActivityGame.this, "Partita conclusa",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();


                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if(answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();

                    //controllo che sia l'ultima domanda
                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(ActivityGame.this, "Partita conclusa",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();


                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //controllo se la risposta è giusta
                if(answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                    Toast.makeText(ActivityGame.this, "Corretto!", Toast.LENGTH_SHORT).show();

                    //controllo che sia l'ultima domanda
                    if(turn < list.size()){
                        turn++;
                        newQuestion(turn);
                    }else{
                        Toast.makeText(ActivityGame.this, "Partita conclusa",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(ActivityGame.this, "Sbagliato!", Toast.LENGTH_SHORT).show();


                }

            }
        });

    }

    private void newQuestion(int number) {
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
                //cambio il testo del primo bottone con il nome della bandiera giusta
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

