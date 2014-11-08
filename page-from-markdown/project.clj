(defproject page-from-markdown "0.1.0-SNAPSHOT"
  :source-paths ["src" "dev"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2342"]
                 [ring "1.2.2"]
                 [compojure "1.1.6"]
                 [enlive "1.1.5"]
                 ;; ReactJS wrapper
                 [reagent "0.4.2"]
                 ;; Client-side routing
                 [secretary "1.2.0"]
                 ;; CSS
                 [garden "1.2.1"] 

                 ;; Markdown parser
                 [markdown-clj "0.9.54"] ]

  :min-lein-version "2.4.3"

  :plugins [;; Emacs repl
            [cider/cider-nrepl "0.8.0-SNAPSHOT"]
            ;; CSS
            [lein-garden "0.2.0"]
            ;; brepl
            [com.cemerick/austin "0.1.4"]
            ;; cljs builder
            [lein-cljsbuild "1.0.3"] ]

  :garden {:builds [{;; Optional name of the build:
                     :id "screen"
                     ;; The var containing your stylesheet:
                     :stylesheet page-from-markdown.css.screen/screen
                     ;; Compiler flags passed to `garden.core/css`:
                     :compiler {;; Where to save the file:
                                :output-to "resources/public/css/screen.css"
                                ;; Compress the output?
                                :pretty-print? false}}]}
  
 :cljsbuild {:builds [{;; Optional name of the build:
                        :id "page-from-markdown"
                        ;; Directories of interest:
                        :source-paths ["src" "dev"]
                        ;; Compiler flags:
                        :compiler {;; Where to save the file:
                                   :output-to "resources/public/js/app.js"
                                   ;; Where to put the output directory
                                   :output-dir "resources/public/js/out"
                                   ;; Source-maps
                                   :source-map "resources/public/js/app.js.map"
                                   ;; Optimizations:
                                   :optimizations :whitespace}}]})
