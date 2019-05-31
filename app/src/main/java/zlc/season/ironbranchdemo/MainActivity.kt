package zlc.season.ironbranchdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import zlc.season.ironbranch.ioThread
import zlc.season.ironbranch.mainThread
import zlc.season.ironbranch.singleIoThread

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_io.setOnClickListener {
            for (i in 0 until 10) {
                ioThread {
                    Thread.sleep(1000)
                    Log.d(TAG, Thread.currentThread().name)
                }
            }
        }

        btn_single.setOnClickListener {
            for (i in 0 until 10) {
                singleIoThread {
                    Thread.sleep(1000)
                    Log.d(TAG, Thread.currentThread().name)
                }
            }
        }

        btn_main.setOnClickListener {
            for (i in 0 until 10) {
                mainThread {
                    Thread.sleep(500)
                    Log.d(TAG, Thread.currentThread().name)
                }
            }
        }
    }
}
