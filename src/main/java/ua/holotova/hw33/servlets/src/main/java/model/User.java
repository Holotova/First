package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String currentTime;
    private String ip;
    private String userAgent;

    @Override
    public String toString() {
        return "currentTime = " + currentTime + " ip= " + ip + " userAgent = " + userAgent;
    }
}