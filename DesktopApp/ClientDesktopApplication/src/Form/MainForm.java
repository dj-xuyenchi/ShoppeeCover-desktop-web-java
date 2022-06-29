/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form;

import ClassLib.Account;
import ClassLib.ImageFromSql;
import javax.swing.ImageIcon;
import Services.Img;
import Services.Services;
import java.awt.Color;
import java.awt.Container;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class MainForm extends javax.swing.JFrame {

    // This is variable Form do not delete or update if you guys do not understand applacation stream
    private SignUpForm _signUpForm;
    private SignInForm _signInForm;
    private Container _con;
    private Services services;
    private List<ImageFromSql> listDecor;

    // This is variable Form do not delete or update if you guys do not understand applacation stream
    public MainForm() {
        initComponents();
        services = new Services();
        services.conectServer();
        listDecor = services.getList();
        setLogoAndContent();
        _con = this.getContentPane();
        _con.setBackground(Color.WHITE);
        setLocationRelativeTo(this);
    }

    public MainForm(Account a) {
        initComponents();
        setLogoAndContent();
        setAccount(a.getName());
        _con = this.getContentPane();
        _con.setBackground(Color.WHITE);
        setLocationRelativeTo(this);
    }

    private void setAccount(String s) {
        jlabelSignUp.removeMouseListener(jlabelSignUp.getMouseListeners()[0]);
        jlabelSignUp.setText("Xin chào:");
        jlabelSignIn.removeMouseListener(jlabelSignIn.getMouseListeners()[0]);
        jlabelSignIn.setText(s);
    }

    private void setLogoAndContent() {
        try {
            ImageIcon imgLogo = new ImageIcon(Img.create_img_from_byte(listDecor.get(0).getData()));
            ImageIcon imgLogoName = new ImageIcon(Img.create_img_from_byte(listDecor.get(1).getData()));
            ImageIcon imgLogoSearch = new ImageIcon(Img.create_img_from_byte(listDecor.get(2).getData()));
            ImageIcon imgLogoBag = new ImageIcon(Img.create_img_from_byte(listDecor.get(3).getData()));
            ImageIcon imgPanel1 = new ImageIcon(Img.create_img_from_byte(listDecor.get(4).getData()));
            ImageIcon imgPanel2 = new ImageIcon(Img.create_img_from_byte(listDecor.get(5).getData()));
            ImageIcon logo1k = new ImageIcon(Img.create_img_from_byte(listDecor.get(6).getData()));
            ImageIcon logoCard = new ImageIcon(Img.create_img_from_byte(listDecor.get(7).getData()));
            ImageIcon logoCheap = new ImageIcon(Img.create_img_from_byte(listDecor.get(8).getData()));
            ImageIcon logoFreeShip = new ImageIcon(Img.create_img_from_byte(listDecor.get(9).getData()));
            ImageIcon logoLux = new ImageIcon(Img.create_img_from_byte(listDecor.get(10).getData()));
            ImageIcon pannel3 = new ImageIcon(Img.create_img_from_byte(listDecor.get(11).getData()));
            ImageIcon[] catalogies = {new ImageIcon(Img.create_img_from_byte(listDecor.get(12).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(13).getData())),
                new ImageIcon(Img.create_img_from_byte(listDecor.get(14).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(15).getData())),
                new ImageIcon(Img.create_img_from_byte(listDecor.get(16).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(17).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(18).getData())),
                new ImageIcon(Img.create_img_from_byte(listDecor.get(19).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(20).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(21).getData())),
                new ImageIcon(Img.create_img_from_byte(listDecor.get(22).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(23).getData()))};
            ImageIcon[] logoSanSales = {new ImageIcon(Img.create_img_from_byte(listDecor.get(24).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(25).getData()))};
            ImageIcon[] slide = {new ImageIcon(Img.create_img_from_byte(listDecor.get(26).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(27).getData())), new ImageIcon(Img.create_img_from_byte(listDecor.get(28).getData()))};
            JLabel[] listLabelCatalogies = {jlabelCatalogi1, jlabelCatalogi2, jlabelCatalogi3, jlabelCatalogi4, jlabelCatalogi5, jlabelCatalogi6, jlabelCatalogi7, jlabelCatalogi8, jlabelCatalogi9, jlabelCatalogi10,
                jlabelCatalogi11, jlabelCatalogi12};
            for (int i = 0; i < catalogies.length; i++) {
                listLabelCatalogies[i].setIcon(new ImageIcon(Img.resizer(catalogies[i].getImage(), 107, 107)));
            }
            btnSearch.setIcon(new ImageIcon(Img.resizer(imgLogoSearch.getImage(), 41, 41)));
            jlabelPanel3.setIcon(new ImageIcon(Img.resizer(pannel3.getImage(), 926, 104)));
            jlabelLogo1k.setIcon(new ImageIcon(Img.resizer(logo1k.getImage(), 121, 84)));
            jlabelCardDt.setIcon(new ImageIcon(Img.resizer(logoCard.getImage(), 121, 84)));
            jlabelLogoCheap.setIcon(new ImageIcon(Img.resizer(logoCheap.getImage(), 121, 84)));
            jlabelLogoLux.setIcon(new ImageIcon(Img.resizer(logoLux.getImage(), 121, 84)));
            jlabelLogoFreeShip.setIcon(new ImageIcon(Img.resizer(logoFreeShip.getImage(), 121, 84)));
            jlabelPanel1.setIcon(new ImageIcon(Img.resizer(imgPanel1.getImage(), 367, 105)));
            jlabelPanel2.setIcon(new ImageIcon(Img.resizer(imgPanel2.getImage(), 367, 105)));
            jlabelLogoShop.setIcon(new ImageIcon(Img.resizer(imgLogo.getImage(), 102, 93)));
            jlabelShopName.setIcon(new ImageIcon(Img.resizer(imgLogoName.getImage(), 100, 30)));
            jlabelLogoBag.setIcon(new ImageIcon(Img.resizer(imgLogoBag.getImage(), 40, 30)));
            Thread slideImg = new Thread() {
                @Override
                public void run() {
                    int i = 0;
                    while (true) {
                        i++;
                        if (i > 2) {
                            i = 0;
                        }
                        jlabelSlide.setIcon(new ImageIcon(Img.resizer(slide[i].getImage(), 549, 219)));
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                }
            };
            slideImg.start();
            Thread logoSales = new Thread() {
                @Override
                public void run() {
                    int i = 0;
                    while (true) {
                        i++;
                        if (i > 1) {
                            i = 0;
                        }
                        jlabelSanSales.setIcon(new ImageIcon(Img.resizer(logoSanSales[i].getImage(), 121, 84)));
                        try {
                            Thread.sleep(600);
                        } catch (Exception e) {
                        }
                    }
                }
            };
            logoSales.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelMain = new javax.swing.JPanel();
        jlabelSlide = new javax.swing.JLabel();
        jlabelPanel1 = new javax.swing.JLabel();
        jlabelPanel2 = new javax.swing.JLabel();
        jlabelSanSales = new javax.swing.JLabel();
        jlabelLogoCheap = new javax.swing.JLabel();
        jlabelLogo1k = new javax.swing.JLabel();
        jlabelLogoFreeShip = new javax.swing.JLabel();
        jlabelLogoLux = new javax.swing.JLabel();
        jlabelCardDt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlabelPanel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlabelCatalogi1 = new javax.swing.JLabel();
        jlabelCatalogi6 = new javax.swing.JLabel();
        jlabelCatalogi2 = new javax.swing.JLabel();
        jlabelCatalogi3 = new javax.swing.JLabel();
        jlabelCatalogi4 = new javax.swing.JLabel();
        jlabelCatalogi5 = new javax.swing.JLabel();
        jlabelCatalogi7 = new javax.swing.JLabel();
        jlabelCatalogi8 = new javax.swing.JLabel();
        jlabelCatalogi9 = new javax.swing.JLabel();
        jlabelCatalogi10 = new javax.swing.JLabel();
        jlabelCatalogi11 = new javax.swing.JLabel();
        jlabelCatalogi12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jlabelLogoShop = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlabelBecomeSeller = new javax.swing.JLabel();
        jlabelSignUp = new javax.swing.JLabel();
        jlabelSignIn = new javax.swing.JLabel();
        jlabelShopName = new javax.swing.JLabel();
        txtSearchField = new javax.swing.JTextField();
        jlabelLogoBag = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jlabelTopSearched1 = new javax.swing.JLabel();
        jlabelTopSearched2 = new javax.swing.JLabel();
        jlabelTopSearched3 = new javax.swing.JLabel();
        jlabelTopSearched4 = new javax.swing.JLabel();
        jlabelTopSearched5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shoppee");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximizedBounds(new java.awt.Rectangle(1376, 979, 979, 979));
        setMaximumSize(new java.awt.Dimension(1376, 979));
        setMinimumSize(new java.awt.Dimension(1376, 979));

        jpanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jpanelMain.setEnabled(false);
        jpanelMain.setMaximumSize(new java.awt.Dimension(944, 821));
        jpanelMain.setMinimumSize(new java.awt.Dimension(944, 821));
        jpanelMain.setPreferredSize(new java.awt.Dimension(1360, 870));

        jlabelPanel1.setMaximumSize(new java.awt.Dimension(367, 105));
        jlabelPanel1.setMinimumSize(new java.awt.Dimension(367, 105));

        jlabelPanel2.setMaximumSize(new java.awt.Dimension(367, 105));
        jlabelPanel2.setMinimumSize(new java.awt.Dimension(367, 105));

        jlabelSanSales.setMaximumSize(new java.awt.Dimension(121, 84));
        jlabelSanSales.setMinimumSize(new java.awt.Dimension(121, 84));

        jlabelLogoCheap.setMaximumSize(new java.awt.Dimension(121, 84));
        jlabelLogoCheap.setMinimumSize(new java.awt.Dimension(121, 84));

        jlabelLogo1k.setMaximumSize(new java.awt.Dimension(121, 84));
        jlabelLogo1k.setMinimumSize(new java.awt.Dimension(121, 84));

        jlabelLogoFreeShip.setMaximumSize(new java.awt.Dimension(121, 84));
        jlabelLogoFreeShip.setMinimumSize(new java.awt.Dimension(121, 84));

        jlabelLogoLux.setMaximumSize(new java.awt.Dimension(121, 84));
        jlabelLogoLux.setMinimumSize(new java.awt.Dimension(121, 84));

        jlabelCardDt.setMaximumSize(new java.awt.Dimension(121, 84));
        jlabelCardDt.setMinimumSize(new java.awt.Dimension(121, 84));

        jSeparator1.setMaximumSize(new java.awt.Dimension(926, 10));
        jSeparator1.setMinimumSize(new java.awt.Dimension(926, 10));

        jLabel5.setFont(new java.awt.Font("Barlow Condensed", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("DANH MỤC");

        jlabelCatalogi1.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi1.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi6.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi6.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi2.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi2.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi3.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi3.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi4.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi4.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi5.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi5.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi7.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi7.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi8.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi8.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi9.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi9.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi10.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi10.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi11.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi11.setMinimumSize(new java.awt.Dimension(107, 107));

        jlabelCatalogi12.setMaximumSize(new java.awt.Dimension(107, 107));
        jlabelCatalogi12.setMinimumSize(new java.awt.Dimension(107, 107));

        javax.swing.GroupLayout jpanelMainLayout = new javax.swing.GroupLayout(jpanelMain);
        jpanelMain.setLayout(jpanelMainLayout);
        jpanelMainLayout.setHorizontalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpanelMainLayout.createSequentialGroup()
                                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpanelMainLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(236, 236, 236))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelMainLayout.createSequentialGroup()
                                        .addComponent(jlabelCatalogi1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(jlabelCatalogi2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jlabelCatalogi3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlabelCatalogi11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlabelCatalogi4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)))
                                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabelCatalogi5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabelCatalogi12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabelCatalogi8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabelCatalogi6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlabelPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelMainLayout.createSequentialGroup()
                                .addComponent(jlabelSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabelPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabelPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpanelMainLayout.createSequentialGroup()
                                .addComponent(jlabelSanSales, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlabelLogoCheap, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jlabelLogo1k, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(jlabelLogoFreeShip, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jlabelLogoLux, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jlabelCardDt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpanelMainLayout.createSequentialGroup()
                                .addComponent(jlabelCatalogi7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jlabelCatalogi9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jlabelCatalogi10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        jpanelMainLayout.setVerticalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabelSlide, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addComponent(jlabelPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabelPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanelMainLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jlabelLogoCheap, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpanelMainLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlabelSanSales, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabelLogo1k, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabelLogoFreeShip, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelMainLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlabelLogoLux, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanelMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jlabelCardDt, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelCatalogi1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelCatalogi7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi12, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelCatalogi10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(254, 87, 35));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setMaximumSize(new java.awt.Dimension(1358, 104));
        jPanel8.setMinimumSize(new java.awt.Dimension(1358, 104));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kênh Người Bán");

        jlabelBecomeSeller.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelBecomeSeller.setForeground(new java.awt.Color(255, 255, 255));
        jlabelBecomeSeller.setText("Trở thành Người bán Shoppee");

        jlabelSignUp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelSignUp.setForeground(new java.awt.Color(255, 255, 255));
        jlabelSignUp.setText("Đăng Ký");
        jlabelSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabelSignUpMouseClicked(evt);
            }
        });

        jlabelSignIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlabelSignIn.setForeground(new java.awt.Color(255, 255, 255));
        jlabelSignIn.setText("Đăng Nhập");
        jlabelSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlabelSignInMouseClicked(evt);
            }
        });

        jlabelShopName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtSearchField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearchField.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchField.setText("Tìm kiếm sản phẩm, thương hiệu, tên Shop....");
        txtSearchField.setMargin(new java.awt.Insets(0, 2, 0, 0));
        txtSearchField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchFieldMouseClicked(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setBorder(null);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jlabelTopSearched1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelTopSearched1.setMaximumSize(new java.awt.Dimension(104, 16));
        jlabelTopSearched1.setMinimumSize(new java.awt.Dimension(104, 16));

        jlabelTopSearched2.setForeground(new java.awt.Color(255, 255, 255));
        jlabelTopSearched2.setMaximumSize(new java.awt.Dimension(104, 16));
        jlabelTopSearched2.setMinimumSize(new java.awt.Dimension(104, 16));

        jlabelTopSearched3.setForeground(new java.awt.Color(255, 255, 255));
        jlabelTopSearched3.setMaximumSize(new java.awt.Dimension(104, 16));
        jlabelTopSearched3.setMinimumSize(new java.awt.Dimension(104, 16));

        jlabelTopSearched4.setForeground(new java.awt.Color(255, 255, 255));
        jlabelTopSearched4.setMaximumSize(new java.awt.Dimension(104, 16));
        jlabelTopSearched4.setMinimumSize(new java.awt.Dimension(104, 16));

        jlabelTopSearched5.setForeground(new java.awt.Color(255, 255, 255));
        jlabelTopSearched5.setMaximumSize(new java.awt.Dimension(104, 16));
        jlabelTopSearched5.setMinimumSize(new java.awt.Dimension(104, 16));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hỗ Trợ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Thông Báo");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlabelLogoShop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlabelShopName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jlabelTopSearched1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlabelTopSearched2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlabelTopSearched3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlabelTopSearched4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlabelTopSearched5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jlabelLogoBag, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlabelBecomeSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabelSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlabelSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlabelBecomeSeller)
                    .addComponent(jlabelSignUp)
                    .addComponent(jlabelSignIn)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelLogoShop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlabelShopName, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSearchField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(jlabelLogoBag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlabelTopSearched1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabelTopSearched2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabelTopSearched3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabelTopSearched4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlabelTopSearched5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jlabelShopName.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jpanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jpanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchFieldMouseClicked
        txtSearchField.setText("");
    }//GEN-LAST:event_txtSearchFieldMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        MainFormList main = new MainFormList("",listDecor);
        this.dispose();
        main.setVisible(true);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jlabelSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelSignInMouseClicked
        _signInForm = new SignInForm();
        this.dispose();
        _signInForm.setVisible(true);

    }//GEN-LAST:event_jlabelSignInMouseClicked

    private void jlabelSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlabelSignUpMouseClicked
        _signUpForm = new SignUpForm();
        this.dispose();
        _signUpForm.setVisible(true);
    }//GEN-LAST:event_jlabelSignUpMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlabelBecomeSeller;
    private javax.swing.JLabel jlabelCardDt;
    private javax.swing.JLabel jlabelCatalogi1;
    private javax.swing.JLabel jlabelCatalogi10;
    private javax.swing.JLabel jlabelCatalogi11;
    private javax.swing.JLabel jlabelCatalogi12;
    private javax.swing.JLabel jlabelCatalogi2;
    private javax.swing.JLabel jlabelCatalogi3;
    private javax.swing.JLabel jlabelCatalogi4;
    private javax.swing.JLabel jlabelCatalogi5;
    private javax.swing.JLabel jlabelCatalogi6;
    private javax.swing.JLabel jlabelCatalogi7;
    private javax.swing.JLabel jlabelCatalogi8;
    private javax.swing.JLabel jlabelCatalogi9;
    private javax.swing.JLabel jlabelLogo1k;
    private javax.swing.JLabel jlabelLogoBag;
    private javax.swing.JLabel jlabelLogoCheap;
    private javax.swing.JLabel jlabelLogoFreeShip;
    private javax.swing.JLabel jlabelLogoLux;
    private javax.swing.JLabel jlabelLogoShop;
    private javax.swing.JLabel jlabelPanel1;
    private javax.swing.JLabel jlabelPanel2;
    private javax.swing.JLabel jlabelPanel3;
    private javax.swing.JLabel jlabelSanSales;
    private javax.swing.JLabel jlabelShopName;
    private javax.swing.JLabel jlabelSignIn;
    private javax.swing.JLabel jlabelSignUp;
    private javax.swing.JLabel jlabelSlide;
    private javax.swing.JLabel jlabelTopSearched1;
    private javax.swing.JLabel jlabelTopSearched2;
    private javax.swing.JLabel jlabelTopSearched3;
    private javax.swing.JLabel jlabelTopSearched4;
    private javax.swing.JLabel jlabelTopSearched5;
    private javax.swing.JPanel jpanelMain;
    private javax.swing.JTextField txtSearchField;
    // End of variables declaration//GEN-END:variables
}
