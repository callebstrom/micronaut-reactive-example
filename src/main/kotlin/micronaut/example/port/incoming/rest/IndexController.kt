package micronaut.example.port.incoming.rest

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import micronaut.example.numberGenerator
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

@Controller("/")
class IndexController {
    @Get(produces = [MediaType.TEXT_EVENT_STREAM])
    fun index(): Flux<String> {
        return numberGenerator().subscribeOn(Schedulers.parallel())
    }
}