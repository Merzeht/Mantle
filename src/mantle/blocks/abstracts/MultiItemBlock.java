package mantle.blocks.abstracts;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

/**
 * 
 * @author progwml6
 * base class for itemBlocks with different unlocalized names based on metadata
 */

public class MultiItemBlock extends ItemBlock
{
    protected static String blockType[];
    protected static String unlocalizedName;
    protected static String append;

    public MultiItemBlock(int id, String itemBlockUnlocalizedName, String[] blockTypes)
    {
        super(id);
        if (itemBlockUnlocalizedName.isEmpty())
            this.unlocalizedName = super.getUnlocalizedName();
        else
            this.unlocalizedName = itemBlockUnlocalizedName;
        this.blockType = blockTypes;
        this.append = "";
    }

    public MultiItemBlock(int id, String itemBlockUnlocalizedName, String appendToEnd, String[] blockTypes)
    {
        super(id);
        this.unlocalizedName = itemBlockUnlocalizedName;
        this.blockType = blockTypes;
        this.append = appendToEnd;
    }

    public void reverseBlockType ()
    {
        ArrayUtils.reverse(blockType);
    }

    public int getMetadata (int meta)
    {
        return meta;
    }

    public String getUnlocalizedName (ItemStack itemstack)
    {
        int pos = MathHelper.clamp_int(itemstack.getItemDamage(), 0, blockType.length - 1);
        return (new StringBuilder()).append(unlocalizedName).append(".").append(blockType[pos]).append(append).toString();
    }

}
