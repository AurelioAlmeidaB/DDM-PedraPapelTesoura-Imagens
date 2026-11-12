package com.example.ddm7imagem

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var  escolhaUsuario: String
    private lateinit var  escolhaSmart: String
    private var contaSmart: Int = 0
    private var contaUser: Int = 0
    private lateinit var  imgUser: ImageView
    private lateinit var  imgSmart: ImageView
    private lateinit var  imgPedra: ImageView
    private lateinit var  imgPapel: ImageView
    private lateinit var  imgTesoura: ImageView
    private lateinit var  txtResultado: TextView
    private lateinit var  txtUser: TextView
    private lateinit var  txtSmart: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgSmart = findViewById(R.id.imgSmart)
        imgUser = findViewById(R.id.imgUser)
        imgPedra = findViewById(R.id.imgPedra)
        imgPapel = findViewById(R.id.imgPapel)
        imgTesoura = findViewById(R.id.imgTesoura)
        txtResultado = findViewById(R.id.txtResultado)
        txtUser = findViewById(R.id.txtUser)
        txtSmart = findViewById(R.id.txtSmart)

        imgPedra.setOnClickListener {
            escolhaPedra()
        }
        imgPapel.setOnClickListener {
            escolhaPapel()
        }
        imgTesoura.setOnClickListener {
            escolhaTesoura()
        }
    }
    private fun escolhaPedra(){
        escolhaUsuario="pedra"
        imgUser.setImageResource(R.drawable.pedra)
        escolhaApp()
        verGanhador()
    }
    private fun escolhaPapel(){
        escolhaUsuario="papel"
        imgUser.setImageResource(R.drawable.papel)
        escolhaApp()
        verGanhador()
    }
    private fun escolhaTesoura(){
        escolhaUsuario="tesoura"
        imgUser.setImageResource(R.drawable.tesoura)
        escolhaApp()
        verGanhador()
    }

    private fun escolhaApp(){
        val i: Int = Random().nextInt(3)
        if (i==0){
            imgSmart.setImageResource(R.drawable.pedra)
            escolhaSmart="pedra"
        }
        if(i==1){
            imgSmart.setImageResource(R.drawable.papel)
            escolhaSmart="papel"
        }
        if(i==2){
            imgSmart.setImageResource(R.drawable.tesoura)
            escolhaSmart="tesoura"
        }
    }
    private fun verGanhador(){
        if(contaSmart<=4 && contaUser<=4){
            if((escolhaSmart=="tesoura" && escolhaUsuario=="papel") || 
            (escolhaSmart=="papel" && escolhaUsuario=="pedra") || 
            (escolhaSmart=="pedra" && escolhaUsuario=="tesoura")
        ){
            txtResultado.text="SMartphone ganhou" 
            
            contaSmart++;
            txtSmart.text="SMART: $contaSmart"
        }
            else if((escolhaUsuario=="tesoura" && escolhaSmart=="papel") || 
            (escolhaUsuario=="papel" && escolhaSmart=="pedra") || 
            (escolhaUsuario=="pedra" && escolhaSmart=="tesoura")
        ){
            txtResultado.text="Usuário ganhou" 
        
            contaUser++;
            txtUser.text="USER: $contaUser"
        }
            else{
            txtResultado.text="Empate"
         
        }
        }
    else if(contaUser>contaSmart){
        txtResultado.text="parabens, voce venceu a queda"
        txtResultado.setTextColor(
            Color.parseColor("#FFFF0000")
           
        )
         limpaImagens()
    }
    else{
        txtResultado.text="voce perdeu a queda para a maquina"
     txtResultado.setTextColor(
            Color.parseColor("#FFFF0000")
           
        )
         limpaImagens()
    }
    }
    
    private fun limpaImagens(){
        val limpaPedra= findViewById<ImageView>(R.id.imgPedra)
        limpaPedra.setImageResource(R.drawable.padrao)

        val limpaPapel= findViewById<ImageView>(R.id.imgPapel)
        limpaPapel.setImageResource(R.drawable.padrao)

        val limpaTesoura= findViewById<ImageView>(R.id.imgTesoura)
        limpaTesoura.setImageResource(R.drawable.padrao)

        val limpaUsuario= findViewById<ImageView>(R.id.imgUser)
        limpaUsuario.setImageResource(R.drawable.padrao)

        val limpaSmart= findViewById<ImageView>(R.id.imgSmart)
        limpaSmart.setImageResource(R.drawable.padrao)
    }
}