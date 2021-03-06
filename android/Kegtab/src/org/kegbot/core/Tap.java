/*
 * Copyright 2012 Mike Wakerly <opensource@hoho.com>.
 *
 * This file is part of the Kegtab package from the Kegbot project. For
 * more information on Kegtab or Kegbot, see <http://kegbot.org/>.
 *
 * Kegtab is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free
 * Software Foundation, version 2.
 *
 * Kegtab is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with Kegtab. If not, see <http://www.gnu.org/licenses/>.
 */
package org.kegbot.core;

/**
 * Represents a physical keg tap.
 */
public class Tap {

  /**
   * Name of this tap.
   */
  private final String mName;

  /**
   * Number of milliliters per flow meter tick. May be zero.
   */
  private double mMlPerTick = 0.0;

  /**
   * Name of the flow meter backing this tap.
   */
  private final String mMeterName;

  /**
   * Name of the relay backing this tap, if any.
   */
  private final String mRelayName;

  /**
   * Constructs a new tap instance.
   *
   * @param name
   *          the name of the tap
   * @param mlPerTick
   *          number of milliliters per flow meter tick
   * @param meterName
   *          meter name, which should match the meter's name in the kegbot
   *          backend
   * @param relayName
   *          relay name, if any
   */
  public Tap(String name, float mlPerTick, String meterName, String relayName) {
    mName = name;
    mMlPerTick = mlPerTick;
    mMeterName = meterName;
    mRelayName = relayName;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("[Tap").append(" meterName=").append(mMeterName)
    .append(" name=").append(mName).append(" mlPerTick=").append(mMlPerTick).append("]");
    return builder.toString();
  }

  /**
   * Returns the volume corresponding to the number of ticks given.
   *
   * @param ticks
   * @return
   */
  public double getVolumeMlForTicks(int ticks) {
    return ticks * mMlPerTick;
  }

  public double getMlPerTick() {
    return mMlPerTick;
  }

  public void setMlPerTick(double mlPerTick) {
    mMlPerTick = mlPerTick;
  }

  public String getName() {
    return mName;
  }

  public String getMeterName() {
    return mMeterName;
  }

  public String getRelayName() {
    return mRelayName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((mMeterName == null) ? 0 : mMeterName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Tap other = (Tap) obj;
    if (mMeterName == null) {
      if (other.mMeterName != null)
        return false;
    } else if (!mMeterName.equals(other.mMeterName))
      return false;
    return true;
  }

}
