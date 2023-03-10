(ns reactor-core.sink.empty
  (:refer-clojure :exclude [empty])
  (:require [reactor-core.sink.protocols :as p])
  (:import (reactor.core.publisher Sinks$Empty)))

(extend-type Sinks$Empty
  p/EmitOperator
  (-try-emit-empty [empty] (.tryEmitEmpty empty))
  (-try-emit-error [empty error] (.tryEmitError empty error))
  p/CountOperator
  (-subscriber-count [empty] (.currentSubscriberCount empty)))
