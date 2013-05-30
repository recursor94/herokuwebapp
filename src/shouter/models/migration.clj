(ns shouter.models.migration
  (:require [clojure.java.jdbc :as sql]))


(defn all []
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/with-query-results results
      ["SELECT * FROM shouts ORDER BY ID DESC"]
      (into [] results))))


(defn create [shout]
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/insert-values :shouts [:body] [shout])))
