-- Author: Lashmini A D
-- CTS DN 5.0 - Week1 - PL/SQL - Exercise03 - Scenario 1
-- ProcessMonthlyInterest - Apply 1% interest to all savings accounts

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    FOR rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = rec.AccountID;

        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ID: ' || rec.AccountID);
    END LOOP;
END;
/