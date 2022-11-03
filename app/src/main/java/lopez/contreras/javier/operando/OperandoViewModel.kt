package lopez.contreras.javier.operando

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.util.*

const val CURRENT_OPERANDO_1_KEY = "CURRENT_OPERANDO1_KEY"
const val CURRENT_OPERATOR_KEY = "CURRENT_OPERATOR_KEY"
const val CURRENT_OPERANDO_2_KEY = "CURRENT_OPERANDO_2_KEY"
class OperandoViewModel( private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val operatorsList = listOf("+","-","*")
    private var  operando1_saved: Int
        get() = savedStateHandle[CURRENT_OPERANDO_1_KEY] ?: 0
        set(value) = savedStateHandle.set(CURRENT_OPERANDO_1_KEY, value)
    private var  operando2_saved: Int
        get() = savedStateHandle[CURRENT_OPERANDO_2_KEY] ?: 0
        set(value) = savedStateHandle.set(CURRENT_OPERANDO_2_KEY, value)
    private var  operator_saved: Int
        get() = savedStateHandle[CURRENT_OPERATOR_KEY] ?: 0
        set(value) = savedStateHandle.set(CURRENT_OPERATOR_KEY, value)

    val operando1:Int
        get() = operando1_saved
    val operando2:Int
        get() = operando2_saved
    val  operator: String
        get() = operatorsList[operator_saved]

    fun newRandom(){
        operando1_saved = (0..9).random()
        operando2_saved = (0..9).random()
        operator_saved = (0..2).random()
    }
    fun IntRange.random() =
        Random().nextInt((endInclusive + 1) - start) + start
}