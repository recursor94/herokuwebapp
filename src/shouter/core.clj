(ns shouter.core
  (:use [compojure.core :only (defroutes GET)]
        [ring.adapter.jetty :as ring]
        [hiccup.page :only (html5)])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [shouter.controllers.shouts :as shouts]
            [shouter.views.layout :as layout]))

(comment
  (defn index []
    (html5
     [:head
      [:title "Hello World"]]
     [:body
      [:div {:id "content"} "Hello World"]])))

(def application (handler/site routes))

(defn start [port]
  (run-jetty application {:port port :join? false}))

(defroutes routes
  shouts/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))


(defn -main []

  (let [port (Integer/parseInt
              (or (System/getenv "PORT") "8080"))]
    (start port)))
