package com.github.revival.common.api;

import com.github.revival.common.enums.EnumPrehistoricAI;

public interface IPrehistoricAI {
 EnumPrehistoricAI.Activity aiActivityType();
 EnumPrehistoricAI.Attacking aiAttackType();
 EnumPrehistoricAI.Climbing aiClimbType();
 EnumPrehistoricAI.Dexterity aiDexterityType();
 EnumPrehistoricAI.Following aiFollowType();
 EnumPrehistoricAI.Jumping aiJumpType();
 EnumPrehistoricAI.Response aiResponseType();
 EnumPrehistoricAI.Stalking aiStalkType();
 EnumPrehistoricAI.Taming aiTameType();
 EnumPrehistoricAI.Untaming aiUntameType();
}
