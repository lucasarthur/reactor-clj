(ns reactor-core.sink.operations
  (:require
   [reactor-core.sink.empty]
   [reactor-core.sink.many]
   [reactor-core.sink.one]
   [reactor-core.sink.protocols :as p]))

(defn try-emit-value [value sink]
  (p/-try-emit-value sink value))

(defn try-emit-empty [sink]
  (p/-try-emit-empty sink))

(defn try-emit-error
  ([sink] (try-emit-error (Exception.) sink))
  ([error sink] (p/-try-emit-error sink error)))

(defn try-emit-complete [sink]
  (p/-try-emit-complete sink))

(defn subscriber-count [sink]
  (p/-subscriber-count sink))

(defn ->flux [many]
  (.asFlux many))

(defn ->mono [one-or-empty]
  (.asMono one-or-empty))
