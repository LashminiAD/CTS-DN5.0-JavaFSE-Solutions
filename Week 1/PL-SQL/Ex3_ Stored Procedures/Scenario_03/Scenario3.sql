-- Author: Lashmini A D
-- CTS DN 5.0 - Week1 - PL/SQL - Exercise03 - Scenario 3
-- TransferFunds - Transfer money between accounts with balance check

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
    insufficient_funds EXCEPTION;
BEGIN
    -- Check current balance of source account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Deduct from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    -- Add to destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || p_amount || ' from Account ' 
        || p_from_account || ' to Account ' || p_to_account);

EXCEPTION
    WHEN insufficient_funds THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance in Account ' || p_from_account);
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Account not found.');
END;
/