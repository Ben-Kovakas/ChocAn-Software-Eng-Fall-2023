package edu.ua.cs.cs200.project4;

import java.util.ArrayList;
import java.util.List;

public class ProviderRecords {
  
  private List<Provider> providers;
  
  public ProviderRecords() {
    providers = new ArrayList<Provider>();
  }
  
  public Provider getProvider(int providerID) {
    return null;
    //TODO parse through the list of providers and find the right one
  }
  
  public void addProvider(Provider provider) {
    providers.add(provider);
    //TODO parse through the list of providers and find the right one
  }
  public void removeProvider(Provider provider) {
    providers.remove(provider);
    //TODO parse through the list of providers and find the right one
  }
  
  public List<Provider> getAllProviders() {
    return null;
    //TODO parse through the list of providers and find the right one
  }
}
