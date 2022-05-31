public class TrickController {
    public static Trick update(Long id, Trick trick) {
        Trick oldTrick = Trick.findById(id);
        
        oldTrick.setName(trick.getName());
        oldTrick.setDifficult(trick.getDifficult());
        oldTrick.setBalls(trick.getBalls());
        oldTrick.setDescription(trick.getDescription());
        oldTrick.setSiteswap(trick.getSiteswap());
        oldTrick.setPreRequisites(trick.getPreRequisites());

        return oldTrick;
    }   
}
