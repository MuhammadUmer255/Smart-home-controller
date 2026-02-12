import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

abstract class SmartDevice {
    private String name;
    private boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public String getName() {
        return name;
    }


    public boolean isOn() {
        return isOn;
    }

    public void toggle() {
        isOn = !isOn;
    }

    public abstract String getStatus();
}

class Light extends SmartDevice {
    private int brightness;
    public Light(String name) {
        super(name);
        this.brightness = 50;


    }

    public int getBrightness() {
        return brightness;
    }


    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public String getStatus() {
        return "Light " + getName() + " is " + (isOn() ? "On" : "Off") + ", Brightness: " + brightness + "%";



    }
}
class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String name) {
        super(name);
        this.temperature = 22;

    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }


    @Override
    public String getStatus() {
        return "Thermostat " + getName() + " is " + (isOn() ? "On" : "Off") + ", Temperature: " + temperature + "°C";
    }
}

 class SmartHomeController {
     private JFrame frame;
     private JPanel mainPanel;
     private DefaultListModel<String> deviceListModel;
     private ArrayList<SmartDevice> devices;

     public SmartHomeController() {
         devices = new ArrayList<>();
         frame = new JFrame("Smart Home Controller");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(600, 400);

         mainPanel = new JPanel(new BorderLayout());
         deviceListModel = new DefaultListModel<>();
         JList<String> deviceList = new JList<>(deviceListModel);
         JScrollPane scrollPane = new JScrollPane(deviceList);
         mainPanel.add(scrollPane, BorderLayout.CENTER);

         JPanel buttonPanel = new JPanel(new FlowLayout());

         JButton addLightButton = new JButton("Add Light");
         JButton addThermostatButton = new JButton("Add Thermostat");
         JButton controlButton = new JButton("Control Device");
         JButton removeButton = new JButton("Remove Device");

         addLightButton.addActionListener(e -> addDevice(new Light("Light " + (devices.size() + 1))));
         addThermostatButton.addActionListener(e -> addDevice(new Thermostat("Thermostat " + (devices.size() + 1))));
         controlButton.addActionListener(e -> controlDevice(deviceList.getSelectedIndex()));
         removeButton.addActionListener(e -> removeDevice(deviceList.getSelectedIndex()));

         buttonPanel.add(addLightButton);
         buttonPanel.add(addThermostatButton);
         buttonPanel.add(controlButton);
         buttonPanel.add(removeButton);

         mainPanel.add(buttonPanel, BorderLayout.SOUTH);
         frame.add(mainPanel);
         frame.setVisible(true);
     }

     private void addDevice(SmartDevice device) {
         devices.add(device);
         deviceListModel.addElement(device.getName());
     }

     private void removeDevice(int index) {
         if (index >= 0 && index < devices.size()) {
             devices.remove(index);
             deviceListModel.remove(index);
         } else {
             JOptionPane.showMessageDialog(frame, "Please select a valid device to remove.", "Error", JOptionPane.ERROR_MESSAGE);
         }
     }

     private void controlDevice(int index) {
         if (index >= 0 && index < devices.size()) {
             SmartDevice device = devices.get(index);

             if (device instanceof Light) {
                 Light light = (Light) device;
                 JPanel lightPanel = new JPanel(new GridLayout(2, 2));
                 lightPanel.add(new JLabel("Brightness:"));
                 JSlider brightnessSlider = new JSlider(0, 100, light.getBrightness());
                 lightPanel.add(brightnessSlider);
                 brightnessSlider.addChangeListener(e -> light.setBrightness(brightnessSlider.getValue()));
                 lightPanel.add(new JLabel("On/Off:"));
                 JCheckBox lightToggle = new JCheckBox("Toggle", light.isOn());
                 lightPanel.add(lightToggle);
                 lightToggle.addActionListener(e -> light.toggle());

                 JOptionPane.showMessageDialog(frame, lightPanel, "Control Light", JOptionPane.PLAIN_MESSAGE);
             }
             else if (device instanceof Thermostat)
             {
                 Thermostat thermostat = (Thermostat) device;
                 JPanel thermostatPanel = new JPanel(new GridLayout(2, 2));
                 thermostatPanel.add(new JLabel("Temperature:"));
                 JSlider temperatureSlider = new JSlider(15, 30, thermostat.getTemperature());
                 thermostatPanel.add(temperatureSlider);
                 temperatureSlider.addChangeListener(e -> thermostat.setTemperature(temperatureSlider.getValue()));
                 thermostatPanel.add(new JLabel("On/Off:"));
                 JCheckBox thermostatToggle = new JCheckBox("Toggle", thermostat.isOn());
                 thermostatPanel.add(thermostatToggle);
                 thermostatToggle.addActionListener(e -> thermostat.toggle());

                 JOptionPane.showMessageDialog(frame, thermostatPanel, "Control Thermostat", JOptionPane.PLAIN_MESSAGE);
             }

             deviceListModel.set(index, device.getStatus());
         }
         else {
             JOptionPane.showMessageDialog(frame, "Please select a valid device to control.", "Error", JOptionPane.ERROR_MESSAGE);
         }
     }

     private static void showSplashScreen() {
         JWindow splash = new JWindow();
         JPanel content = new JPanel(new BorderLayout());
             ImageIcon splashImage = new ImageIcon("C:\\Users\\Infinix\\Downloads\\Screenshot 2025-01-27 232604.png");
             JLabel splashLabel = new JLabel(splashImage);
             content.add(splashLabel, BorderLayout.CENTER);
             splash.getContentPane().add(content);
             splash.setSize(500, 300);
             splash.setLocationRelativeTo(null);
             splash.setVisible(true);

         try {
             Thread.sleep(500);
         }
         catch (InterruptedException e) {
             e.printStackTrace();
         }
         splash.setVisible(true);
         splash.dispose();
     }
     public static void main(String[] args) {
         showSplashScreen();
         new SmartHomeController();
     }
 }

