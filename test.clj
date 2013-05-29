(require '[clojure.java.jdbc :as sql])

(let [db-host "192.168.1.7"
      db-port 5432
      db-name "shouter"]

  (def db {:classname "org.postgres.Driver"
           :subprotocol "postgresql"
           :subname (str "//" "192.168.1.7" ":" db-port "/" db-name)
           :user "pi"
           :password "cocospano94"}))
