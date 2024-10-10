package com.yosi.controller.addOrderFrame;

import com.yosi.additions.Alert;
import com.yosi.model.Client;
import com.yosi.model.OrderAddress;
import com.yosi.model.Shipment;
import com.yosi.services.YosiDAODB;
import com.yosi.services.YosiService;
import com.yosi.view.frame.mainFrame.CenterBar.OrdersList.ListPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.AddOrder;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddAddressPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddClientPanel;
import com.yosi.view.frame.orderFame.addOrderFrame.addOrderPanels.AddShipmentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public record OrderController(AddClientPanel clientPanel, AddShipmentPanel shipmentPanel, AddAddressPanel addressPanel,
                              AddOrder order, ListPanel listPanel, YosiService yosiService) implements Alert {

    static String nipRegex = "^[0-9]{10}$";
    static String phoneNumberRegex = "^[0-9]{3}\s*[0-9]{3}\s*[0-9]{3}\s*$";
    static String countryRegex = "^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ ]{1,37}$";
    static String streetRegex = "^[a-zA-ZąćęłńóśźżĄĆĘŁŃÓŚŹŻ ]{1,27}$";
    static String houseNumberRegexAndLocal = "^[0-9]{1,6}$";
    static String postalCodeRegex = "^[0-9-]{1,10}$";
    static String shippingRegex = "^[0-9]{1,3}$";




    public ActionListener addAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = clientPanel.getNameTextField().getText();
                String nip = clientPanel.getNipTextField().getText();
                long nipClint = Long.parseLong(nip);
                String city = clientPanel.getCityTextField().getText();


                String weight = shipmentPanel.getWeightText().getText();
                int weightAddress = Integer.parseInt(weight);
                String width = shipmentPanel.getWidthText().getText();
                int widthAddress = Integer.parseInt(width);
                String height = shipmentPanel.getHeightText().getText();
                int heightAddress = Integer.parseInt(height);
                String length = shipmentPanel.getLengthText().getText();
                int lengthAddress = Integer.parseInt(length);


                String country = addressPanel.getCountryText().getText();
                String addressCity = addressPanel.getCityText().getText();
                String street = addressPanel.getStreetText().getText();
                String houseNumber = addressPanel.getHouseNumberText().getText();
                int houseNumberShipment = Integer.parseInt(houseNumber);
                String localNumber = addressPanel.getLocalNumberText().getText();
                int localNumberAddress = Integer.parseInt(localNumber);
                String postalCode = addressPanel.getPostalCodeText().getText();
                String contactNumber = addressPanel.getContactNumberText().getText();
                long contactNumberShipment = Long.parseLong(contactNumber);


                Client clint = new Client(name, nipClint, city);


                Shipment shipment = new Shipment(weightAddress, widthAddress, heightAddress, lengthAddress, "0");
                ArrayList<Shipment> shipmentList = new ArrayList<Shipment>();
                shipmentList.add(shipment);


                OrderAddress orderAddress = new OrderAddress(country, addressCity, street, houseNumberShipment, localNumberAddress, postalCode, contactNumberShipment);
                ArrayList<OrderAddress> orderAddressList = new ArrayList<OrderAddress>();
                orderAddressList.add(orderAddress);

                clint.setOrderAddress(orderAddressList);
                orderAddress.setClient(clint);

                clint.setShipments(shipmentList);
                shipment.setClient(clint);
                if (!nip.matches(nipRegex)) {
                    setWarningMsg("zly nip");
                } else if(!contactNumber.matches(phoneNumberRegex)) {
                    setWarningMsg("Zły numer telefonu");
                } else if(!country.matches(countryRegex)){
                    setWarningMsg("Zła nazwa Państwa");
                }else if(!city.matches(countryRegex)){
                    setWarningMsg("Zła nazwa Miasta");
                }else if(!localNumber.matches(houseNumberRegexAndLocal)){
                    setWarningMsg("Zły numer lokalu");
                }else if(!houseNumber.matches(houseNumberRegexAndLocal)){
                    setWarningMsg("Zła nazwa Domu");
                }else if(!postalCode.matches(postalCodeRegex)){
                    setWarningMsg("Zły kod pocztowy");
                }else if(!street.matches(streetRegex)){
                    setWarningMsg("Zła nazwa ulicy");
                }else if(!weight.matches(shippingRegex) ||!width.matches(shippingRegex)
                        ||!height.matches(shippingRegex) ||!length.matches(shippingRegex)){
                    setWarningMsg("Złe wymiary");
                }else{
                    yosiService.save(clint);
                    listPanel.refreshList();
                    order.dispatchEvent(new WindowEvent(order, WindowEvent.WINDOW_CLOSING));
                }


            }
        };
    }




}
