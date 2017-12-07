/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IPFSTest;

import io.ipfs.api.IPFS;
import io.ipfs.api.IPFS.File;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;
import java.io.IOException;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author anish
 */
public class IPFSTesting{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        IPFS ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        NamedStreamable.ByteArrayWrapper file = new NamedStreamable.ByteArrayWrapper("hello.txt", "Hey there. It's me from Nepal".getBytes());
        MerkleNode addResult = ipfs.add(file).get(0);
        Multihash pointer = addResult.hash;
        System.out.println(pointer.toString());
        //Multihash filePointer = Multihash.fromBase58("QmPZ9gcCEpqKTo6aq61g2nXGUhM4iCL3ewB6LDXZCtioEB");
        byte[] fileContents = ipfs.cat(pointer);
        System.out.println(Base64.encodeBase64String(fileContents));
    }
    
}
