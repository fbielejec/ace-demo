(ns ace-demo.subscriptions
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :content
 (fn [db [_ params]]
   (get db (:id params))))

