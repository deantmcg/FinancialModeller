package financialmodeller;

import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dean McGuigan
 */

public class AccountViewer extends javax.swing.JFrame {
    private boolean simulationRunning = false; // whether or not simulation is running
    private final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    private final NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private Account account;
    private Simulation simulation;
    
    public AccountViewer() {
        initComponents();
        simulation = new Simulation();
        btnCurrent.setSelected(true);
        
        // Hides all components that aren't used for account creation
        jToolBar.hide();
        jTabbedPane.remove(panelTransactions);
        jTabbedPane.remove(panelGraph);
        jTabbedPane.remove(panelBalances);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBalanceError3 = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        panelCreateAccount = new javax.swing.JPanel();
        lblFirstname = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblAccType = new javax.swing.JLabel();
        lblInitialBalance = new javax.swing.JLabel();
        txtFirstname = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtDOB = new javax.swing.JFormattedTextField();
        txtInitialBalance = new javax.swing.JSpinner();
        btnCurrent = new javax.swing.JRadioButton();
        btnSavings = new javax.swing.JRadioButton();
        btnCreate = new javax.swing.JButton();
        lblDOB1 = new javax.swing.JLabel();
        lblBalanceError = new javax.swing.JLabel();
        lblSurnameError = new javax.swing.JLabel();
        lblFirstnameError = new javax.swing.JLabel();
        lblAccTypeError = new javax.swing.JLabel();
        lblDobError = new javax.swing.JLabel();
        panelTransactions = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransactions = new javax.swing.JTable();
        panelGraph = new javax.swing.JPanel();
        panelBalances = new javax.swing.JPanel();
        lblLowestBalance = new javax.swing.JLabel();
        lblHighestBalance = new javax.swing.JLabel();
        jToolBar = new javax.swing.JToolBar();
        btnSimulation = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        lblDate = new javax.swing.JLabel();
        horizontalGlue = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        lblID = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        lblBalance = new javax.swing.JLabel();

        lblBalanceError3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblBalanceError3.setForeground(new java.awt.Color(255, 0, 0));
        lblBalanceError3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblFirstname.setText("Firstname");

        lblSurname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSurname.setText("Surname");

        lblDOB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDOB.setText("D.O.B");

        lblAccType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAccType.setText("Account Type");

        lblInitialBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInitialBalance.setText("Initial Balance");

        txtFirstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSurname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDOB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtDOB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtInitialBalance.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtInitialBalance.setValue(1);
        txtInitialBalance.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtInitialBalanceStateChanged(evt);
            }
        });

        btnCurrent.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCurrent.setText("Current");
        btnCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurrentActionPerformed(evt);
            }
        });

        btnSavings.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSavings.setText("Savings");
        btnSavings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavingsActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblDOB1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDOB1.setText("DD/MM/YYYY");

        lblBalanceError.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblBalanceError.setForeground(new java.awt.Color(255, 0, 0));
        lblBalanceError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblSurnameError.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblSurnameError.setForeground(new java.awt.Color(255, 0, 0));
        lblSurnameError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblFirstnameError.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblFirstnameError.setForeground(new java.awt.Color(255, 0, 0));
        lblFirstnameError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblAccTypeError.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblAccTypeError.setForeground(new java.awt.Color(255, 0, 0));
        lblAccTypeError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblDobError.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblDobError.setForeground(new java.awt.Color(255, 0, 0));
        lblDobError.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelCreateAccountLayout = new javax.swing.GroupLayout(panelCreateAccount);
        panelCreateAccount.setLayout(panelCreateAccountLayout);
        panelCreateAccountLayout.setHorizontalGroup(
            panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateAccountLayout.createSequentialGroup()
                        .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSurname)
                            .addComponent(lblFirstname)
                            .addComponent(lblDOB)
                            .addComponent(lblAccType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDOB)
                            .addComponent(txtSurname)
                            .addGroup(panelCreateAccountLayout.createSequentialGroup()
                                .addComponent(btnCurrent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSavings)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtFirstname)))
                    .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCreateAccountLayout.createSequentialGroup()
                            .addComponent(lblInitialBalance)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtInitialBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateAccountLayout.createSequentialGroup()
                        .addComponent(lblAccTypeError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreateAccountLayout.createSequentialGroup()
                        .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSurnameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFirstnameError, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCreateAccountLayout.createSequentialGroup()
                                .addComponent(lblDOB1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDobError, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                        .addGap(374, 374, 374))
                    .addGroup(panelCreateAccountLayout.createSequentialGroup()
                        .addComponent(lblBalanceError, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelCreateAccountLayout.setVerticalGroup(
            panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFirstname)
                        .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFirstnameError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSurname)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSurnameError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDOB)
                        .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDOB1))
                    .addComponent(lblDobError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAccType)
                        .addComponent(btnCurrent)
                        .addComponent(btnSavings))
                    .addComponent(lblAccTypeError, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblInitialBalance)
                        .addComponent(txtInitialBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBalanceError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Create Account", panelCreateAccount);

        panelTransactions.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type", "Amount", "Date", "Balance After", "Reason for Decline"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTransactions);
        if (tblTransactions.getColumnModel().getColumnCount() > 0) {
            tblTransactions.getColumnModel().getColumn(0).setMinWidth(80);
            tblTransactions.getColumnModel().getColumn(0).setMaxWidth(80);
            tblTransactions.getColumnModel().getColumn(1).setMinWidth(140);
            tblTransactions.getColumnModel().getColumn(1).setMaxWidth(140);
            tblTransactions.getColumnModel().getColumn(2).setMinWidth(140);
            tblTransactions.getColumnModel().getColumn(2).setMaxWidth(140);
            tblTransactions.getColumnModel().getColumn(3).setMinWidth(140);
            tblTransactions.getColumnModel().getColumn(3).setMaxWidth(140);
        }

        javax.swing.GroupLayout panelTransactionsLayout = new javax.swing.GroupLayout(panelTransactions);
        panelTransactions.setLayout(panelTransactionsLayout);
        panelTransactionsLayout.setHorizontalGroup(
            panelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransactionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTransactionsLayout.setVerticalGroup(
            panelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransactionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Transaction History", panelTransactions);

        javax.swing.GroupLayout panelGraphLayout = new javax.swing.GroupLayout(panelGraph);
        panelGraph.setLayout(panelGraphLayout);
        panelGraphLayout.setHorizontalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        panelGraphLayout.setVerticalGroup(
            panelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Graph", panelGraph);

        lblLowestBalance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblLowestBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLowestBalance.setText("The lowest balance recorded was");

        lblHighestBalance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHighestBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHighestBalance.setText("The highest balance recorded was");

        javax.swing.GroupLayout panelBalancesLayout = new javax.swing.GroupLayout(panelBalances);
        panelBalances.setLayout(panelBalancesLayout);
        panelBalancesLayout.setHorizontalGroup(
            panelBalancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBalancesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLowestBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelBalancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBalancesLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblHighestBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelBalancesLayout.setVerticalGroup(
            panelBalancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBalancesLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblLowestBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(panelBalancesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBalancesLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(lblHighestBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(255, Short.MAX_VALUE)))
        );

        jTabbedPane.addTab("Account Balances Report", panelBalances);

        jToolBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar.setRollover(true);

        btnSimulation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSimulation.setText("START SIMULATION");
        btnSimulation.setFocusPainted(false);
        btnSimulation.setFocusable(false);
        btnSimulation.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSimulation.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSimulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimulationActionPerformed(evt);
            }
        });
        jToolBar.add(btnSimulation);
        jToolBar.add(jSeparator1);

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDate.setText("DATE");
        jToolBar.add(lblDate);
        jToolBar.add(horizontalGlue);

        lblID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblID.setText("NAME (TYPE)");
        jToolBar.add(lblID);
        jToolBar.add(jSeparator3);

        lblBalance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBalance.setText("BALANCE");
        jToolBar.add(lblBalance);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Switches the simulation on and off
    private void btnSimulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulationActionPerformed
        if (!simulationRunning)
        {
            simulation.StartSimulation(account);
            btnSimulation.setText("STOP SIMULATION");
            btnSimulation.setForeground(Color.red);
            simulationRunning = true;
        }
        else
        {
            // when button is clicked to stop the simulation
            account = simulation.StopSimulation();
            btnSimulation.setText("START SIMULATION");
            btnSimulation.setForeground(Color.black);
            simulationRunning = false;
            clearTable();
            populateTable(account);
            btnSimulation.hide();

            // Populate and display Graph
            GraphPanel mainPanel = new GraphPanel(account.getTransactionss());
            mainPanel.setPreferredSize(new Dimension(800, 600));
            jTabbedPane.addTab("Graph", mainPanel);
            
            // Populate and display Report
            jTabbedPane.add("Account Balances Report", panelBalances);
            populateBalanceReport();
        }
    }//GEN-LAST:event_btnSimulationActionPerformed

    private void btnCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurrentActionPerformed
        // selects Current option and deselects Savings option
        btnCurrent.setSelected(true);
        btnSavings.setSelected(false);
        
        // ensures a value less than the minimum balance isn't selected
        if(Double.parseDouble(txtInitialBalance.getValue().toString()) < 1)
        {
            txtInitialBalance.setValue(1);
            lblBalanceError.setText("£1 Minimum required for this account");
        }
        else
        {
            lblBalanceError.setText("");
        }
    }//GEN-LAST:event_btnCurrentActionPerformed

    private void btnSavingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavingsActionPerformed
        // selects Savings option and deselects Current option
        btnSavings.setSelected(true);
        btnCurrent.setSelected(false);
        
        // ensures a value less than the minimum balance isn't selected
        if(Double.parseDouble(txtInitialBalance.getValue().toString()) < 100)
        {
            txtInitialBalance.setValue(100);
            lblBalanceError.setText("£100 Minimum balance required for this account");
        }
        else
        {
            lblBalanceError.setText("");
        }
    }//GEN-LAST:event_btnSavingsActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

        lblBalanceError.setText("");
        try
        {
            if (!(isLetters(txtFirstname.getText()) && isLetters(txtSurname.getText())))
            {
                throw new IllegalStateException();
            }
            
            // creates a new account holder from user input
            AccountHolder holder = new AccountHolder(txtFirstname.getText(), 
                    txtSurname.getText(), df.parse(txtDOB.getText()));
            AccountType type;
            if (btnCurrent.isSelected())
                type = AccountType.Current;
            else
                type = AccountType.Savings;

            // creates the new account
            switch (type)
            {
                case Savings:
                    account = new SavingsAccount(holder, new Date(), 
                            Integer.parseInt(txtInitialBalance.getValue().toString()));
                    break;
                case Current:
                    account = new CurrentAccount(holder, new Date(), 
                            Integer.parseInt(txtInitialBalance.getValue().toString()));
                    break;
            }
            // sets account balance from user input
            account.setBalance(Double.parseDouble(txtInitialBalance.getValue().toString()));

            // adds components that display account details
            jTabbedPane.remove(panelCreateAccount);
            jTabbedPane.add("Transaction History", panelTransactions);
            setFormLabels();
            updateSimulation();
        }
        catch (Exception ex)
        {
            // ensures all required information has been input
            String error = "* Field required";
            if (!(isLetters(txtFirstname.getText()) && isLetters(txtSurname.getText())))
            {
                JOptionPane.showMessageDialog(panelCreateAccount, 
                        "No numbers allowed in first or surname.");
            }
            else
            {
                JOptionPane.showMessageDialog(panelCreateAccount, 
                        "Please complete all fields");
            }

            if (txtFirstname.getText().equals(""))
                lblFirstnameError.setText(error);
            else
                lblFirstnameError.setText("");

            if (txtSurname.getText().equals(""))
                lblSurnameError.setText(error);
            else
                lblSurnameError.setText("");

            if (txtDOB.getText().equals(""))
                lblDobError.setText(error);
            else
                lblDobError.setText("");

            if (!btnCurrent.isSelected() && !btnSavings.isSelected())
                lblAccTypeError.setText(error);
            else
                lblAccTypeError.setText("");

        }
    }//GEN-LAST:event_btnCreateActionPerformed
    
    private boolean isLetters(String input) 
    {
        return input.matches("[a-zA-Z]+");
    }
    
    /*
    prevents initial balance input from being lower than account minimum balance
    */
    private void txtInitialBalanceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtInitialBalanceStateChanged
        // ensures a number can't be entered less than the minimum balance
        if (btnCurrent.isSelected())
        {
            if (Integer.parseInt(txtInitialBalance.getValue().toString()) < 1)
            {
                txtInitialBalance.setValue(1);
                lblBalanceError.setText("£1 minimum balance required for this account");
            }
            else
            {
                lblBalanceError.setText("");
            }
        }
        else if (btnSavings.isSelected())
        {
            if (Integer.parseInt(txtInitialBalance.getValue().toString()) < 100)
            {
                txtInitialBalance.setValue(100);
                lblBalanceError.setText("£100 minimum balance required for this account");
            }
            else
            {
                lblBalanceError.setText("");
            }
        }
    }//GEN-LAST:event_txtInitialBalanceStateChanged

    private void populateTable(Account acc)
    {
        DefaultTableModel model = (DefaultTableModel) tblTransactions.getModel();
        
        for (Transaction t : acc.getTransactionss())
        {
            Object [] row;
            
            // if transaction was unsuccessful - reason why will be displayed
            if (t.getSuccess())
                row = new Object[] {t.getType(), formatter.format(t.getAmount()), 
                    df.format(t.getDate()), formatter.format(t.getBalanceAfter()), "-"};
            else
                row = new Object[] {t.getType(), formatter.format(t.getAmount()), 
                    df.format(t.getDate()), formatter.format(t.getBalanceAfter()), t.getDescription()};
            model.addRow(row);
        } 
        
        tblTransactions.setModel(model);
    }
    
    private void setFormLabels()
    {
        /*
        called when an acocunt has been created and simulation is 
        ready to be started
        */
        lblID.setText(account.getHolder().getFullname() + " (" + account.getAccountType() + ")");
        lblBalance.setText(formatter.format(account.getBalance()));
        jToolBar.show();
    }
    
    private void updateSimulation()
    {
        /*
        refreshes all dynamic form components every second
        affected labels: account balance, table, current date
        */
        Runnable runnable = new Runnable() 
        {
            public void run() 
            {
                lblDate.setText("Current date: " + df.format(simulation.getDate()));
                try
                {
                    clearTable();
                    populateTable(simulation.getAccount());
                    lblBalance.setText(formatter.format(simulation.getAccount().getBalance()));
                }
                catch (Exception ex)
                {
                }
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
    }
    
    private void clearTable()
    {
        // clears the table contents
        DefaultTableModel model = (DefaultTableModel) tblTransactions.getModel();
        model.setRowCount(0);
        tblTransactions.setModel(model);
    }
    
    /*
    When the simulation is stopped you can calculate the report. You can do this by calling the below methods.
    They methods will return a String in the following format (amount date) e.g "17085.0 27/07/2019"
    You can use the code below to get each value then all you need to do is put the "bal" and "date" string into
    the correct place on the GUI.
    */
    private void populateBalanceReport()
    {
        // populates the labels on the Report panel
        lblHighestBalance.setText("The highest balance recorded was " + 
                Report.GetHighestBal(account.getTransactionss()));
        lblLowestBalance.setText("The lowest balance recorded was " + 
                Report.GetLowestBal(account.getTransactionss()));
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AccountViewer accViewer = new AccountViewer();
                accViewer.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JRadioButton btnCurrent;
    private javax.swing.JRadioButton btnSavings;
    private javax.swing.JToggleButton btnSimulation;
    private javax.swing.Box.Filler horizontalGlue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JLabel lblAccType;
    private javax.swing.JLabel lblAccTypeError;
    private javax.swing.JLabel lblBalance;
    private javax.swing.JLabel lblBalanceError;
    private javax.swing.JLabel lblBalanceError3;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDOB1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDobError;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblFirstnameError;
    private javax.swing.JLabel lblHighestBalance;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblInitialBalance;
    private javax.swing.JLabel lblLowestBalance;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblSurnameError;
    private javax.swing.JPanel panelBalances;
    private javax.swing.JPanel panelCreateAccount;
    private javax.swing.JPanel panelGraph;
    private javax.swing.JPanel panelTransactions;
    private javax.swing.JTable tblTransactions;
    private javax.swing.JFormattedTextField txtDOB;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JSpinner txtInitialBalance;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
