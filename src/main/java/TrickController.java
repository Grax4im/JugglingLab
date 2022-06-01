public class TrickController {
    public static Trick update(Long id, Trick trick) {
        Trick oldTrick = Trick.findById(id);
        
        oldTrick.setName(trick.getName());
        oldTrick.setDifficult(trick.getDifficult());
        oldTrick.setBalls(trick.getBalls());
        oldTrick.setDescription(trick.getDescription());
        oldTrick.setSiteswap(trick.getSiteswap());
        oldTrick.setPreRequisites(trick.getPreRequisites());
        oldTrick.persistAndFlush();
        return oldTrick;
    }   
    public static boolean create(Trick trick) {
        if(trick.getName() == null || trick.getBalls() < 3 || trick.getDescription() == null || trick.getDifficult() < 0) return false;
        trick.persistAndFlush();
        return true;
    }
}
