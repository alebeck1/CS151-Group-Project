import javax.swing.*;

/**
 * JPanel for showing the information of the AI responses.
 * doesn't have any thinking, just displays it's 3 parameters
 * LLMResponseView should define those parameters.
 * */
public class ResponsePanel extends JPanel {
    private String modelName;
    private String waitTime;
    private String response;
    private String status;

    public ResponsePanel(String name) {
        modelName = name;
        waitTime = "";
        response = "";
        status = "WAITING";
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        updatePanel();
    }

    /**
     * updates the panel view based on the parameters.
     * The main view class will not need to update these, they update every time
     * updatePanel is called. LLMResponseView should alter the parameters so it displays
     * the desired results.
     * */
    public void updatePanel() {
        removeAll();

        JLabel nameLabel = new JLabel(modelName);
        add(nameLabel);
        JLabel statusLabel = new JLabel(status);
        add(statusLabel);
        JLabel waitLabel = new JLabel(waitTime);
        add(waitLabel);

        JTextArea responseArea = new JTextArea(response);
        //these define how the responseArea interacts
        //cannot be edited by user
        responseArea.setEditable(false);
        //moves text to next line when it reaches the right edge
        responseArea.setLineWrap(true);
        //moves whole the world to next line instead of part of one
        responseArea.setWrapStyleWord(true);
        //add(responseArea);
        JScrollPane scrollPane = new JScrollPane(responseArea);
        add(scrollPane);

        revalidate();
        repaint();
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}