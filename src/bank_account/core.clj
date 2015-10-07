(ns bank-account.core
  (:require [schema.core :as s]))

(def my-bank-account (atom 0))

;(defrecord Person [fname lname bank-account-id

(s/defrecord Person
  [fname :- s/Str
   lname :- s/Str
   bank-account-id :- s/Int])


(def counter (atom 0))

(def bank-accounts (atom {}))

(def people (atom {}))

(defn withdraw [amount bank-atom]
  (swap! bank-atom #(- % amount)))

(defn deposit [amount bank-atom]
  (swap! bank-atom #(+ % amount)))

(defn add-new-account
  [{:keys [type]}]
  (let [id (swap! counter inc)]
    (println "the type is" type)
    (swap! bank-accounts assoc id {:id id :type type :amount 0})))




()9090909l
