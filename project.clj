(defproject babs-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
								[org.clojure/clojure "1.6.0"]
								[clj-time "0.8.0"]
								[org.clojure/data.csv "0.1.2"]]
  :main ^:skip-aot babs-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
