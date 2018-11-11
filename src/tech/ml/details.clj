(ns tech.ml.details
  (:require [tech.ml.dataset :as dataset]))


(defn options->label-map
  [options label-keys]
  (let [label-keys (dataset/normalize-keys label-keys)]
    (when-not (= 1 (count label-keys))
      (throw (ex-info "More than 1 label detected"
                      {:label-keys label-keys})))
    (if-let [retval (get-in options [:label-map (first label-keys)])]
      retval
      (throw (ex-info "Failed to find label map"
                      {:label-keys label-keys
                       :label-maps (get options :label-map)})))))
