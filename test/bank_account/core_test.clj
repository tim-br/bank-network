(ns bank-account.core-test
  (:require [clojure.test :refer :all]
            [bank-account.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest bank-account-test
  (testing "exists a bank account"
    (swap! my-bank-account inc)
    (is (= @my-bank-account 1))))

(deftest withdraw-works
  (testing "that withdraw works"
    (reset! my-bank-account 500)
    (withdraw 20 my-bank-account)
    (is (= @my-bank-account 480))
    (reset! my-bank-account 0)))

(deftest deposit-works
  (testing "that deposit works"
    (let [old-balance @my-bank-account]
      (reset! my-bank-account 200)
      (deposit 46 my-bank-account)
      (is (= @my-bank-account 246))
      (reset! my-bank-account old-balance))))

(deftest can-add-account
  (testing "need to be able to add new accounts"
    (let [new-account { :type "checking"}]
      (add-new-account new-account)
      (is (= (:amount (@bank-accounts @counter)) 0))
      (is (= (:type (@bank-accounts @counter)) "checking")))))

(deftest can-add-account-with-initial-sum
  (let [new-account {:amount 65 :type "savings"}]
    (add-new-account new-account)
    (is (= 65 (:amount (@bank-accounts @counter))))))

(deftest can-create-person
  (testing "person type"
    (let [new-person-map {:fname "tim" :lname "Will" :id 32}
          person (add-person new-person-map)]
      (is (= (:fname person) "tim")))))
