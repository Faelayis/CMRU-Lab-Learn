`index.ino`<br>
Create: 22 ก.ย. 2568 time 16:49<br>
```ino
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

const char* ssid = "@CMRU-SCI";
const char* password = "";

const char* serverBase = "http://10.80.101.14:3000/";
const int LDR_PIN = A0;   
const int RAIN_SENSOR_PIN = D2;

WiFiClient wifiClient;
HTTPClient http;

void setup() {
  Serial.begin(9600);
  pinMode(RAIN_SENSOR_PIN, INPUT);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    int ldrValue = analogRead(LDR_PIN);
    int rainSensorValue = digitalRead(RAIN_SENSOR_PIN);
    
    String rainStatus = (rainSensorValue == HIGH) ? "dry" : "wet";
    String rainfall = "25mm";
    String serverURL = String(serverBase) + "?rainfall=" + rainfall + 
                      "&ldr_reading=" + String(ldrValue) + 
                      "&rain_sensor_status=" + rainStatus;
    
    Serial.println("=== Sensor Readings ===");
    Serial.println("Rainfall: " + rainfall);
    Serial.println("LDR Reading: " + String(ldrValue));
    Serial.println("Rain Sensor Status: " + rainStatus);
    Serial.println("Request URL: " + serverURL);
    
    http.begin(wifiClient, serverURL);
    int httpCode = http.GET(); 

    if (httpCode > 0) {
      Serial.printf("HTTP Response code: %d\n", httpCode);
      String payload = http.getString();
      Serial.println("Response: " + payload);
    } else {
      Serial.printf("HTTP Request failed, error: %s\n", http.errorToString(httpCode).c_str());
    }

    http.end();
  } else {
    Serial.println("WiFi not connected");
  }

  delay(5000); 
}

```
