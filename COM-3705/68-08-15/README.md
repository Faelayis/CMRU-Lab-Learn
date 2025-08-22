`dhp.ino`<br>
Create: 22 ส.ค. 2568 time 08:34<br>
```ino
#include <DHT.h>

#define DHTPIN D4   
#define DHTTYPE DHT11  

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  delay(2000);

  float h = dht.readHumidity();
  float tC = dht.readTemperature();
  float tF = dht.readTemperature(true);

  if (isnan(h) || isnan(tC)) {
    return;
  }

  Serial.print(F("Humidity: "));
  Serial.print(h);
  Serial.print(F(" %  Temperature: "));
  Serial.print(tC);
  Serial.print(F(" C ("));
  Serial.print(tF);
  Serial.println(F(" F)"));
}
```
