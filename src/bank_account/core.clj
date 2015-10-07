(ns bank-account.core)

(def my-bank-account (atom 0))

(def counter (atom 0))

(def bank-accounts (atom {}))

(defn withdraw [amount bank-atom]
  (swap! bank-atom #(- % amount)))

(defn deposit [amount bank-atom]
  (swap! bank-atom #(+ % amount)))

(defn add-new-account
  [{:keys [type]}]
  (let [id (swap! counter inc)]
    (println "the type is" type)
    (swap! bank-accounts assoc id {:id id :type type :amount 0})))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(add-new-account {:type "checking"})

(:type (@bank-accounts 6))

(add-new-account {:type "saving"})



