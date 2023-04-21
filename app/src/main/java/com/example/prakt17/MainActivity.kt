package com.example.prakt17

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import com.example.prakt17.R.id.*

class MainActivity : AppCompatActivity() {
    private lateinit var spinners: Spinner
    private lateinit var lenthedittext: EditText
    private lateinit var widthedittext: EditText
    private lateinit var heightedittext: EditText
    private lateinit var radiusedittext: EditText
    private lateinit var resultrad: TextView
    private lateinit var lastshape: String
    private lateinit var imageview1: ImageView
    private lateinit var imageview2: ImageView
    private lateinit var imageview3: ImageView

    fun showDimensions(
        visibleLength: Boolean,
        visibleWidth: Boolean,
        visibleHeight: Boolean,
        visibleRadius: Boolean,
        visibleim1: Boolean,
        visibleim2: Boolean,
        visibleim3: Boolean
    ) {
        lenthedittext.visibility = if (visibleLength) View.VISIBLE else View.GONE
        widthedittext.visibility = if (visibleWidth) View.VISIBLE else View.GONE
        heightedittext.visibility = if (visibleHeight) View.VISIBLE else View.GONE
        radiusedittext.visibility = if (visibleRadius) View.VISIBLE else View.GONE
        imageview1.visibility=if (visibleim1) View.VISIBLE else View.GONE
        imageview2.visibility=if (visibleim2) View.VISIBLE else View.GONE
        imageview3.visibility=if (visibleim3) View.VISIBLE else View.GONE
    }

    fun calculatePerimeter() {

        when (spinners.selectedItem.toString()) {
                getString(R.string.Treug) -> {
                    val a = lenthedittext.text.toString().toFloat()
                    val b = widthedittext.text.toString().toFloat()
                    val c = heightedittext.text.toString().toFloat()
                    val perimeter = a + b + c
                    resultrad.text = getString(R.string.result_perimeter, perimeter)
                    val resultintetn=Intent(this, resultActivity::class.java)
                    resultintetn.putExtra("Результат",perimeter)
                    startActivity(resultintetn)
            }
            getString(R.string.Pryamug) -> {
                val a = lenthedittext.text.toString().toFloat()
                val b = widthedittext.text.toString().toFloat()
                val perimeter = 2 * (a + b)
                resultrad.text = getString(R.string.result_perimeter, perimeter)
                val resultintetn=Intent(this, resultActivity::class.java)
                resultintetn.putExtra("Результат",perimeter)
                startActivity(resultintetn)
            }
            getString(R.string.Krug) -> {
                val r = radiusedittext.text.toString().toFloat()
                val perimeter = 2 * Math.PI.toFloat() * r
                resultrad.text = getString(R.string.result_perimeter, perimeter)
                val resultintetn=Intent(this, resultActivity::class.java)
                resultintetn.putExtra("Результат",perimeter)
                startActivity(resultintetn)



            }

            }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        imageview1=findViewById(imageView2)
        imageview2=findViewById(imageView3)
        imageview3=findViewById(imageView4)
        spinners = findViewById(simple_spinner2)
        lenthedittext = findViewById(edit_leng)
        widthedittext = findViewById(edit_width)
        heightedittext = findViewById(edit_hrigh)
        radiusedittext = findViewById(edit_radiues)
        resultrad = findViewById(rass)
        val shapearray = resources.getStringArray((R.array.shape_array))
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapearray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinners.adapter = adapter

        val storage = getPreferences(Context.MODE_PRIVATE)
        lastshape = storage.getString(getString(R.string.last_shape_key), "") ?: ""

        spinners.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {

                val shape = parent.getItemAtPosition(position).toString()
                when (shape) {
                    getString(R.string.Treug) -> showDimensions(

                        visibleLength = true,
                        visibleWidth = true,
                        visibleHeight = true,
                        visibleRadius = false,
                        visibleim1 = false,
                        visibleim2 = false,
                        visibleim3 = true
                    )
                    getString(R.string.Pryamug) -> showDimensions(
                        visibleLength = true,
                        visibleWidth = true,
                        visibleHeight = false,
                        visibleRadius = false,
                        visibleim1 = true,
                        visibleim2 = false,
                        visibleim3 = false
                    )
                    getString(R.string.Krug) -> showDimensions(
                        visibleLength = false,
                        visibleWidth = false,
                        visibleHeight = false,
                        visibleRadius = true,
                        visibleim1 = false,
                        visibleim2 = true,
                        visibleim3 = false

                    )
                }
                lastshape = shape


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        when (lastshape) {
            getString(R.string.Treug) -> showDimensions(
                visibleLength = true,
                visibleWidth = true,
                visibleHeight = true,
                visibleRadius = false,
                visibleim1 = false,
                visibleim2 = false,
                visibleim3 = true
            )
            getString(R.string.Pryamug) -> showDimensions(
                visibleLength = true,
                visibleWidth = true,
                visibleHeight = false,
                visibleRadius = false,
                visibleim1 = true,
                visibleim2 = false,
                visibleim3 = false
            )
            getString(R.string.Krug) -> showDimensions(
                visibleLength = false,
                visibleWidth = false,
                visibleHeight = false,
                visibleRadius = true,
                visibleim1 = false,
                visibleim2 = true,
                visibleim3 = false
            )


        }

    }

    fun resutaror(view: View) { findViewById<Button>(R.id.calculatr).setOnClickListener {
        calculatePerimeter()

    }}
}

