package com.example.lhweather.entity;

import java.util.List;

import com.example.lhweather.entity.aqi.AirQualityIndex;
import com.example.lhweather.entity.basic.CityBasicInfo;
import com.example.lhweather.entity.daily_weather.WeatherForecast;
import com.example.lhweather.entity.hourly_forecast.HourlyForecast;
import com.example.lhweather.entity.lifesuggestion.LifeSuggestion;
import com.example.lhweather.entity.now.CurrentTimeWeather;

public class QueryWeatherResult {
	private CityBasicInfo basic;
	private AirQualityIndex aqi;
	private LifeSuggestion suggestion;
	private CurrentTimeWeather now;
	private List<WeatherForecast> daily_forecast;
	private List<HourlyForecast> hourly_forecast;
	private String status;
	public QueryWeatherResult(CityBasicInfo basic, AirQualityIndex aqi, LifeSuggestion suggestion,
			CurrentTimeWeather now, List<WeatherForecast> daily_forecast, List<HourlyForecast> hourly_forecast,
			String status) {
		super();
		this.basic = basic;
		this.aqi = aqi;
		this.suggestion = suggestion;
		this.now = now;
		this.daily_forecast = daily_forecast;
		this.hourly_forecast = hourly_forecast;
		this.status = status;
	}
	public QueryWeatherResult() {
		super();
	}
	public CityBasicInfo getBasic() {
		return basic;
	}
	public void setBasic(CityBasicInfo basic) {
		this.basic = basic;
	}
	public AirQualityIndex getAqi() {
		return aqi;
	}
	public void setAqi(AirQualityIndex aqi) {
		this.aqi = aqi;
	}
	public LifeSuggestion getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(LifeSuggestion suggestion) {
		this.suggestion = suggestion;
	}
	public CurrentTimeWeather getNow() {
		return now;
	}
	public void setNow(CurrentTimeWeather now) {
		this.now = now;
	}
	public List<WeatherForecast> getDaily_forecast() {
		return daily_forecast;
	}
	public void setDaily_forecast(List<WeatherForecast> daily_forecast) {
		this.daily_forecast = daily_forecast;
	}
	public List<HourlyForecast> getHourly_forecast() {
		return hourly_forecast;
	}
	public void setHourly_forecast(List<HourlyForecast> hourly_forecast) {
		this.hourly_forecast = hourly_forecast;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "QueryWeatherResult [basic=" + basic + ", aqi=" + aqi + ", suggestion=" + suggestion + ", now=" + now
				+ ", daily_forecast=" + daily_forecast + ", hourly_forecast=" + hourly_forecast + ", status=" + status
				+ "]";
	}
	
}
