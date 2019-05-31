package zlc.season.ironbranch

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

fun singleIoThread(block: () -> Unit) {
    singleIO.execute(block)
}

fun ioThread(block: () -> Unit) {
    diskIO.execute(block)
}

fun mainThread(block: () -> Unit) {
    mainHandler.post(block)
}

fun isMainThread(): Boolean {
    return Looper.getMainLooper().thread === Thread.currentThread()
}

private val mainHandler by lazy { Handler(Looper.getMainLooper()) }

private val singleIO by lazy {
    Executors.newSingleThreadExecutor(object : ThreadFactory {
        private val threadId = AtomicInteger(0)
        override fun newThread(r: Runnable): Thread {
            val t = Thread(r)
            t.name = "iron_branch_single_io_${threadId.getAndIncrement()}"
            return t
        }
    })
}

private val diskIO by lazy {
    Executors.newFixedThreadPool(4, object : ThreadFactory {
        private val threadId = AtomicInteger(0)
        override fun newThread(r: Runnable): Thread {
            val t = Thread(r)
            t.name = "iron_branch_io_${threadId.getAndIncrement()}"
            return t
        }
    })
}