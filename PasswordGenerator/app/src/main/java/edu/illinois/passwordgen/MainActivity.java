package edu.illinois.passwordgen;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static edu.illinois.passwordgen.R.id.constraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button refreshButton = (Button) findViewById(R.id.refreshButton);
        final Button copyButton = (Button) findViewById(R.id.copyButton);
        final EditText allLengthText = (EditText) findViewById(R.id.allLengthText);
        final EditText numLengthText = (EditText) findViewById(R.id.numLenthText);
        final EditText symbolLengthText = (EditText) findViewById(R.id.symbolLengthText);
        final TextView password = (TextView) findViewById(R.id.password);
        password.setMovementMethod(new ScrollingMovementMethod());

        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                CharSequence passwordText = password.getText();
                CharSequence passwordCopy = passwordText.subSequence(10, passwordText.length());

                ClipData clip = ClipData.newPlainText("password", passwordCopy);
                clipboard.setPrimaryClip(clip);
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length;
                int numLength = 0;
                int symLength = 0;
                String allText = allLengthText.getText().toString();
                String numText = numLengthText.getText().toString();
                String symText = symbolLengthText.getText().toString();

                if (allText.equals("")) {
                    if (!numText.equals("") || !symText.equals("")) {
                        Toast.makeText(v.getContext(), "Error! Please type in the total count.",
                                Toast.LENGTH_SHORT).show();
                    }
                    return; //Return if no input
                }

                try {

                    length = Integer.parseInt(allText);

                    if (!numText.equals("")) {
                        numLength = Integer.parseInt(numText);
                    }

                    if (!symText.equals("")) {
                        symLength = Integer.parseInt(symText);
                    }

                    if (length <= 0) {
                        Toast.makeText(v.getContext(), "Error! Total count has to be positive.",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (numLength < 0 || symLength < 0) {
                        Toast.makeText(v.getContext(), "Error! Partial counts have to be non-negative.",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (numLength + symLength > length) {
                        Toast.makeText(v.getContext(), "Error! Total count has to be bigger than " +
                                "sum of partial counts.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    PasswordGenerator generator = new PasswordGenerator();
                    password.setText("Password: " + generator.getPassword(length, numLength, symLength));

                } catch (NumberFormatException numberFormatException) {
                    Toast.makeText(v.getContext(), "Input should be numbers!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
