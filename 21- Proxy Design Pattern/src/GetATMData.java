// This interface will contain just those methods
// that you want the proxy to provide access to

public interface GetATMData
{
  public ATMState getATMState(ATMMachine atm);
  public int getCashInMachine(ATMMachine atm);
}