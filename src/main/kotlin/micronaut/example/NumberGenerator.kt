package micronaut.example

import reactor.core.publisher.Flux
import java.util.*

fun numberGenerator(): Flux<String> = Flux.from {
    while (true) {
        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) { it.onComplete() }
        it.onNext("test " + Random().nextInt())
    }
}
