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
    (let [new-account { :amount 0 :type "checking"}]
      (add-new-account new-account)
      (is (= (:amount (@bank-accounts @counter)) 0))
      (is (= (:type (@bank-accounts @counter)) "checking")))))

