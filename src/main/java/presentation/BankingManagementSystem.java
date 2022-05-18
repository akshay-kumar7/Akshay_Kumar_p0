package presentation;

import java.util.Scanner;

import exception.SystemException;
import pojos.AccountPojo;
import pojos.UserPojo;
import service.AccountService;
import service.AccountServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class BankingManagementSystem {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		UserService userService = new UserServiceImpl();

		AccountService accountService = new AccountServiceImpl();

		String ch = "y";

		while ("y".equals(ch)) {
			System.out.println("\t\t\t\t\t*******************************************");
			System.out.println("\t\t\t\t\t\tBANKING MANAGEMENT SYSTEM");
			System.out.println("\t\t\t\t\t*******************************************");
			System.out.println("1. Register New User");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("*****************************");
			System.out.println("Please enter an option:");

			int choice = input.nextInt();

			switch (choice) {

			case 1: // Register New User
				UserPojo newUserPojo = new UserPojo();
				// AccountPojo newAccountPojo = new AccountPojo();
				System.out.println("Please enter the username of the user you want to register");
				input.nextLine();
				newUserPojo.setUserName(input.nextLine());

				System.out.println("Please enter the password of the user you want to register");
				newUserPojo.setPwd(input.nextLine());

				System.out.println("Please enter the firstname of the user you want to register");
				newUserPojo.setUserFirstName(input.nextLine());

				System.out.println("Please enter the lastname of the user you want to register");
				newUserPojo.setUserLastName(input.nextLine());

				UserPojo userPojo = null;
				try {
					userPojo = userService.createUser(newUserPojo);
				} catch (SystemException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println("\n*****************************");
				System.out.println("New user added successfully! \nUser ID is :" + userPojo.getUserId());
				System.out.println("*****************************");
				break;

			case 2: // Login Existing User
				UserPojo userLoginPojo = new UserPojo();
				AccountPojo loggedUserAccountPojo = new AccountPojo();
				System.out.println("Enter user name:");
				input.nextLine();
				userLoginPojo.setUserName(input.nextLine());

				System.out.println("Enter user password:");
				userLoginPojo.setPwd(input.nextLine());

				UserPojo returnedLoginUserPojo = null;
				try {
					returnedLoginUserPojo = userService.loginUser(userLoginPojo);
				} catch (SystemException e) {
					System.out.println("**********************************");
					System.out.println("Sorry!! There is some issue with the database...");
					System.out.println("Please try after sometime....");
					System.out.println("**********************************");
					break;
				}

				int loggedUserId = returnedLoginUserPojo.getUserId();
				System.out.println(loggedUserId);
				if (loggedUserId == 0) {
					System.out.println("Wrong username or password. Please try again");
				} else {
					loggedUserAccountPojo.setAcc_id(loggedUserId);
					System.out.println("**********************************");
					System.out.println("Login Successful.");
				}
				char usermenu = 'y';

				while (usermenu == 'y') {

					System.out.println("**********************************");
					System.out.println("User Logged In\n");
					System.out.println("1. Create an Account");
					System.out.println("2. Deposit funds into an Account");
					System.out.println("3. Withdraw funds from an account");
					System.out.println("4. View balance of account");
					System.out.println("5. Transfer funds from one account to another");
					System.out.println("6. Exit\n");
					System.out.println("**********************************");
					System.out.println("Please enter an option:");
					int userchoice = input.nextInt();

					switch (userchoice) {

					case 1: // Create an Account
						AccountPojo newAccountPojo = new AccountPojo();
						System.out.println("Enter the type of Account you want to create");
						input.nextLine();
						newAccountPojo.setAcc_type(input.nextLine());

						System.out.println("Enter the balance of Account");
						newAccountPojo.setAcc_balance(input.nextDouble());

						AccountPojo accountPojo = null;
						try {
							accountPojo = accountService.createAccount(newAccountPojo);
						} catch (SystemException e) {
							System.out.println(e.getMessage());
							break;
						}
						System.out.println("\n*****************************");
						System.out
								.println("New Account added successfully! \nAccount ID is :" + accountPojo.getAcc_id());
						System.out.println("*****************************");

						break;

					case 2: // Deposit Money into the account
						AccountPojo depositAccountPojo = new AccountPojo();
						System.out.println("Please enter Account ID where you want to deposit money :");
						int depositAccountId = input.nextInt();
						depositAccountPojo.setAcc_id(depositAccountId);
						try {
							depositAccountPojo = accountService.getAccount(depositAccountPojo);
						} catch (SystemException e1) {
							e1.printStackTrace();
						}

						System.out.println("Enter the amount you want to deposit into the Account");
						double depositAmount = input.nextDouble();
						double updatedDepositAmount = depositAccountPojo.getAcc_balance() + depositAmount;
						depositAccountPojo.setAcc_balance(updatedDepositAmount);

						try {
							accountService.deposit(depositAccountPojo);
						} catch (SystemException e) {
							System.out.println(e.getMessage());
							break;
						}
						System.out.println("\n*****************************");
						System.out.println("Money Deposited Successfully! \n Your new account balance is:  "
								+ depositAccountPojo.getAcc_balance());
						System.out.println("*****************************");

						break;

					case 3: // Withdraw funds from account
						AccountPojo withdrawAccountPojo = new AccountPojo();
						System.out.println("Please enter Account ID where you want to deposit money :");
						int withdrawAccountId = input.nextInt();
						withdrawAccountPojo.setAcc_id(withdrawAccountId);

						try {
							withdrawAccountPojo = accountService.getAccount(withdrawAccountPojo);
						} catch (SystemException e1) {
							e1.printStackTrace();
						}
						System.out.println("Enter the amount you wouud like to withdraw: ");
						double withdrawAmount = input.nextDouble();
						double updatedWithdrawAmount = withdrawAccountPojo.getAcc_balance() - withdrawAmount;
						if (updatedWithdrawAmount < 0) {
							System.out.println("Account is withdrawn. Transaction Cancelled. Please check the account");
							break;
						} else {
							withdrawAccountPojo.setAcc_balance(updatedWithdrawAmount);
							try {
								accountService.withdraw(withdrawAccountPojo);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("\n*****************************");
							System.out.println("Money Withdrawn Successfully!");
							System.out.println("*****************************");
						}
						break;

					case 4:// view balance of the account
						AccountPojo showBalanceAccountPojo = new AccountPojo();
						System.out.println(
								"Please enter Account ID of the account of which you want to display the balance :");
						int showBalanceId = input.nextInt();
						showBalanceAccountPojo.setAcc_id(showBalanceId);

						AccountPojo balanceAccountPojo = null;
						try {
							balanceAccountPojo = accountService.showBalance(showBalanceAccountPojo);
						} catch (SystemException e) {
							e.printStackTrace();
						}
						System.out.println("\n*****************************");
						System.out.println("Balance of Account with ID" + showBalanceAccountPojo.getAcc_id() + " is :"
								+ showBalanceAccountPojo.getAcc_balance());
						System.out.println("*****************************");
						break;

					case 5: //transfer money from one account to another
						
						AccountPojo fromTransferAccountPojo = new AccountPojo();
						System.out.println("Please enter Account ID from where you want to transfer the money :");
						int fromAccountId = input.nextInt();
						fromTransferAccountPojo.setAcc_id(fromAccountId);
						
						AccountPojo toTransferAccountPojo = new AccountPojo();
						System.out.println("Please enter Account ID where you want to transfer the money :");
						int toAccountId = input.nextInt();
						toTransferAccountPojo.setAcc_id(toAccountId);
						
						try {
							fromTransferAccountPojo = accountService.getAccount(toTransferAccountPojo);
							toTransferAccountPojo = accountService.getAccount(toTransferAccountPojo);
						} catch (SystemException e1) {
							e1.printStackTrace();
						}
						System.out.println("Enter the amount you would like to transfer: ");
						double transferAmount = input.nextDouble();
						fromAccountId=fromTransferAccountPojo.getAcc_id();
						toAccountId=toTransferAccountPojo.getAcc_id();
						try {
								accountService.transferMoney(fromAccountId, toAccountId, transferAmount);
							} catch (SystemException e) {
								System.out.println(e.getMessage());
								break;
							}
							System.out.println("\n*****************************");
							System.out.println("Money Transferred Successfully!");
							System.out.println("*****************************");
						
						
						System.out.println("**********************************");
						System.out.println("Do you want to continue? (y/n) :");
						usermenu = input.next().charAt(0);
						
					case 6:
						userService.exitApplication();
						System.out.println(
								"\n\t\t\t\t\t*******************************************************************");
						System.out.println("\t\t\t\t\t\tThank you for using Banking Management System!!");
						System.out.println(
								"\t\t\t\t\t*******************************************************************");
						System.exit(0);
						break;
					}
					}
				
			case 3:
				System.out.println("\n\t\t\t\t\t*******************************************************************");
				System.out.println("\t\t\t\t\t\tThank you for using Banking Management System!!");
				System.out.println("\t\t\t\t\t*******************************************************************");
				System.exit(0);

			}

		}
	}
}
