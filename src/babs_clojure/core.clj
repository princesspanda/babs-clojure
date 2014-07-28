(ns babs-clojure.core
	(:require [clj-time.core :as t]
						[clj-time.format :as f]
						[clojure.data.csv :as csv]
						[clojure.java.io :as io] )
  (:gen-class))

(def custom-formatter (f/formatter "MM/dd/YYYY"))
(def day-map {
	1 "Monday"
	2 "Tuesday"
	3 "Wednesday"
	4 "Thursday"
	5 "Friday"
	6 "Saturday"
	7 "Sunday"
})

(defn read-file
[filename]
(with-open [in-file (io/reader filename)]
	(doall
	(csv/read-csv in-file))))


(defn parse-date
	[date-str]
	(f/parse custom-formatter date-str))

(defn day-of-week
	[date-time]
	(day-map (t/day-of-week date-time)))

(defn parse-row
	[[date-str & stats]]
	(let [ride-stats (map read-string stats)]
		{
		:date date-str
		:day-of-week (day-of-week (parse-date date-str))
		:systemwide (nth ride-stats 0)
		:sf (nth ride-stats 1)
		:rc (nth ride-stats 2)
		:pa (nth ride-stats 3)
		:mv (nth ride-stats 4)
		:sj (nth ride-stats 5)})
)


(defn parse-lines
[data]
(let [ rows (rest data) ]
(map parse-row rows)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]

	(parse-lines (read-file "resources/data-babs-2014-Q2.csv"))
)


