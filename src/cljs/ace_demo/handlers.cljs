(ns ace-demo.handlers
  (:require [re-frame.core :as re-frame] 
            [ace-demo.db :as db]) )

(re-frame/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))
  
(re-frame/reg-event-db
 :set-content
 (fn [db [_ params]]
   (assoc db (:id params) (:content params))))
