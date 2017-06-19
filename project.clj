(defproject ace-demo "0.0.1-SNAPSHOT"
  :description "Demontrates how to handle mutable JS objects in a re-frame application. "
  :dependencies [[org.clojure/clojurescript "1.9.542"]
                 [reagent "0.6.2"]
                 [re-frame "0.9.3"]
                 [re-frisk "0.3.2"]]
  :resource-paths ["resources"]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.13"]
                                  [figwheel-sidecar "0.5.10"]]                   
                   :plugins [[lein-figwheel "0.5.10" :exclusions [cider/cider-nrepl]]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
  :plugins [[lein-ancient "0.6.10"]
            [lein-cljsbuild "1.1.5"]
            [lein-npm "0.6.2"]]
  :figwheel {:css-dirs ["resources/public/styles"]
             :server-port 8080}
  :npm {:dependencies [[ace "https://github.com/ajaxorg/ace"]]}
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :figwheel {:on-jsload "ace-demo.core/mount-root"}
                        :compiler {:main ace-demo.core
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :closure-defines {goog.DEBUG true}
                                   :source-map-timestamp true
                                   :externs ["node_modules/ace/build/src-min/ace.js"]
                                   :foreign-libs [{:file "node_modules/ace/build/src-min/ace.js"
                                                   :provides ["ace"]}]}}]}
  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"
                                    "test/js"])
