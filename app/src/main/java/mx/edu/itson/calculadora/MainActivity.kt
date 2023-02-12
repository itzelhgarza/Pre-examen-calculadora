package mx.edu.itson.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Declaración variables globales
    lateinit var textResultado: TextView

    //Variables
    private var num1: Int = 0
    private var num2: Int = 0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaración de botones números
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btn3: Button = findViewById(R.id.btn3)
        val btn4: Button = findViewById(R.id.btn4)
        val btn5: Button = findViewById(R.id.btn5)
        val btn6: Button = findViewById(R.id.btn6)
        val btn7: Button = findViewById(R.id.btn7)
        val btn8: Button = findViewById(R.id.btn8)
        val btn9: Button = findViewById(R.id.btn9)
        val btn0: Button = findViewById(R.id.btn0)

        //Declaración botones operaciones
        val division: Button = findViewById(R.id.btnDivision)
        val multiplicacion: Button = findViewById(R.id.btnMulti)
        val resta: Button = findViewById(R.id.btnRes)
        val suma: Button = findViewById(R.id.btnSuma)
        val igual: Button = findViewById(R.id.btnResult)
        val borrar: Button = findViewById(R.id.btnClear)

        //Inicializar variables
        textResultado = findViewById(R.id.textRes)

        btn1.setOnClickListener{
            isEqualZero()
            numeroPresionado("1")}
        btn2.setOnClickListener{
            isEqualZero()
            numeroPresionado("2")}
        btn3.setOnClickListener{
            isEqualZero()
            numeroPresionado("3")}
        btn4.setOnClickListener{
            isEqualZero()
            numeroPresionado("4")}
        btn5.setOnClickListener{
            isEqualZero()
            numeroPresionado("5")}
        btn6.setOnClickListener{
            isEqualZero()
            numeroPresionado("6")}
        btn7.setOnClickListener{
            isEqualZero()
            numeroPresionado("7")}
        btn8.setOnClickListener{
            isEqualZero()
            numeroPresionado("8")}
        btn9.setOnClickListener{
            isEqualZero()
            numeroPresionado("9")}
        btn0.setOnClickListener{
            isEqualZero()
            numeroPresionado("0")}

        suma.setOnClickListener{operacionPresionada((SUMA))}
        resta.setOnClickListener{operacionPresionada((RESTA))}
        division.setOnClickListener{operacionPresionada((DIVISION))}
        multiplicacion.setOnClickListener{operacionPresionada((MULTIPLICACION))}

        borrar.setOnClickListener{
            num1 = 0
            num2 = 0
            textResultado.text = "0"
            operacion = NO_OPERACION
        }

        igual.setOnClickListener{
            var resultado: Int = when(operacion){
                SUMA -> num1+num2
                RESTA -> num1-num2
                DIVISION -> num1/num2
                MULTIPLICACION -> num1*num2
                else -> 0
            }
            textResultado.text = resultado.toString()
        }
    }
    private fun numeroPresionado(digito: String){
        textResultado.text = "${textResultado.text}$digito"

        if(operacion == NO_OPERACION){
            num1 = textResultado.text.toString().toInt()
        }else{
            num2 = textResultado.text.toString().toInt()
        }
    }

    private fun operacionPresionada(operacion: Int){
        this.operacion = operacion
        textResultado.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
    private fun isEqualZero() {
        if (textResultado.text == "0") {
            textResultado.text = ""
        }
    }
}