package com.example.rickmorty

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.rickmorty.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        getCharacterRoot()
    }

    //Instancia del objeto retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Linkear el objeto retrofit con la interfaz
    val call = getRetrofit().create(RickMortyApiService::class.java)

    private fun getCharacterRoot(){
        //Crear la corutina
        CoroutineScope(Dispatchers.IO).launch {
            val response = call.getCharacters(2)
            runOnUiThread{
                if(response.isSuccessful){
                    binding.rvCharacters.adapter = CharachtersAdapter(response.body()!!.results)
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError(){
        Toast.makeText(this, "An error happened", Toast.LENGTH_SHORT).show()
    }
}
