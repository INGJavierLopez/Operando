package lopez.contreras.javier.operando

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import lopez.contreras.javier.operando.databinding.ActivityMainBinding
private var flag: Boolean = true
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val OperandoView: OperandoViewModel by viewModels()
//Listo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.revisar.setOnClickListener {view : View ->
            checkAnwer(view)
        }
        if(flag){
            OperandoView.newRandom()
            flag = false
        }
        setValues()
    }
    private  fun setValues() {
        binding.operador1.text = OperandoView.operando1.toString()
        binding.operador2.text = OperandoView.operando2.toString()
        binding.operando.text = OperandoView.operator
        binding.answer.setText("")
        binding.answer.setSelectAllOnFocus(true)
    }

    private fun checkAnwer(view:View){
        val answer = binding.answer.text
        val result:Int = when (OperandoView.operator) {
            "+" -> {
                OperandoView.operando1 + OperandoView.operando2
            }
            "-" -> {
                OperandoView.operando1 - OperandoView.operando2
            }
            else -> {
                OperandoView.operando1 * OperandoView.operando2
            }
        }
        if(result.toString() == answer.toString()){
            val mySnack = Snackbar.make(view, R.string.correctToast, Snackbar.LENGTH_LONG)
            mySnack.setBackgroundTint(getColor(R.color.green))
            mySnack.show()
            OperandoView.newRandom()
            setValues()

        }
        else{
            val mySnack = Snackbar.make(view, R.string.incorrectToast, Snackbar.LENGTH_LONG)
            mySnack.setBackgroundTint(getColor(R.color.red))
            mySnack.show()
            binding.answer.setSelectAllOnFocus(true)
        }
    }
    //(minVal..maxVal).random()
    //private var caca :Int = (1..5).random()
}


