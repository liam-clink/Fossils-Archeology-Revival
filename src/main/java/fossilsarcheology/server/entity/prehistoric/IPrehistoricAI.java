package fossilsarcheology.server.entity.prehistoric;

public interface IPrehistoricAI {
    PrehistoricEntityTypeAI.Moving getMoveType();

    PrehistoricEntityTypeAI.Activity getActivityType();

    PrehistoricEntityTypeAI.Attacking getAttackType();

    PrehistoricEntityTypeAI.Climbing getClimbType();

    PrehistoricEntityTypeAI.Following getFollowType();

    PrehistoricEntityTypeAI.Jumping getJumpType();

    PrehistoricEntityTypeAI.Response getResponseType();

    PrehistoricEntityTypeAI.Stalking getStalkType();

    PrehistoricEntityTypeAI.Taming getTameType();

    PrehistoricEntityTypeAI.Untaming getUntameType();

    PrehistoricEntityTypeAI.WaterAbility getWaterAbilityType();
}
