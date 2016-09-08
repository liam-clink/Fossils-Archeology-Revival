package fossilsarcheology.server.entity;

import fossilsarcheology.server.enums.PrehistoricAI;

public interface IPrehistoricAI {
    PrehistoricAI.Moving getMoveType();

    PrehistoricAI.Activity getActivityType();

    PrehistoricAI.Attacking getAttackType();

    PrehistoricAI.Climbing getClimbType();

    PrehistoricAI.Following getFollowType();

    PrehistoricAI.Jumping getJumpType();

    PrehistoricAI.Response getResponseType();

    PrehistoricAI.Stalking getStalkType();

    PrehistoricAI.Taming getTameType();

    PrehistoricAI.Untaming getUntameType();

    PrehistoricAI.WaterAbility getWaterAbilityType();
}
